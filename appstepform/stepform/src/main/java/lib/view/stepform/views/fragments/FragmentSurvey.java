package lib.view.stepform.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.IOException;
import java.util.Locale;

import lib.view.stepform.R;
import lib.view.stepform.action.ObserverQuestion;
import lib.view.stepform.models.AbstractSurvey;
import lib.view.stepform.models.Question;
import lib.view.stepform.views.viewpager.ViewPagerDisableMovement;
import lib.view.stepform.views.viewpager.ViewPagerIndicatorWithTextDot;
import lib.view.stepform.views.viewpager.adapter.DefaultStatePagerAdapter;
import lib.view.stepform.views.viewpager.callback.CallbackOnPageChangeListener;
import lib.view.stepform.views.viewpager.listener.DefaultOnPageChangeListener;

public class FragmentSurvey extends Fragment implements ObserverQuestion {

    private AbstractSurvey mModelSurvey;

    private ViewPagerDisableMovement mViewPager;

    private static final String BUNDLE_SURVEY           = "BUNDLE_SURVEY";
    private static final String BUNDLE_LAST_POSITION    = "BUNDLE_LAST_POSITION";
    private static final String BUNDLE_ENABLED_PAGES    = "BUNDLE_ENABLED_PAGES";
    private static final String BUNDLE_ALREADY_CALLING  = "BUNDLE_ALREADY_CALLING";

    private int mLastPosition = -1;

    private boolean enabledPages [];

    public FragmentSurvey() {}

    // TODO: Rename and change types and number of parameters
    public static FragmentSurvey newInstance(AbstractSurvey modelSurvey) {
        FragmentSurvey fragment = new FragmentSurvey();
        fragment.mModelSurvey = modelSurvey;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        enabledPages =  new boolean[mModelSurvey.getQuestions().size()];
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_survey, container, false);

        for (Question q : mModelSurvey.getQuestions())
            q.setObserverQuestion(this);

        if (savedInstanceState != null) {
            mModelSurvey = savedInstanceState.getParcelable(BUNDLE_SURVEY);
            mLastPosition = savedInstanceState.getInt(BUNDLE_LAST_POSITION);
        }

        mViewPager = view.findViewById(R.id.view_pager);
        mViewPager.setEnabled(false);

        mViewPager.setPageTransformer(false, mModelSurvey.pageTransformer());

        PagerAdapter mPagerAdapter = new DefaultStatePagerAdapter(getFragmentManager()
                , mModelSurvey.getQuestions());

        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOffscreenPageLimit(1);


        final ViewPagerIndicatorWithTextDot viewPagerIndicatorWithTextDot = view.findViewById(R.id.view_pager_indicator);

        try {
            viewPagerIndicatorWithTextDot.init(mModelSurvey.getQuestions().size(), 3, 40);
        }
        catch (Exception ioex) {
            Log.e("EXCP", ioex.getMessage());
        }

        ViewPager.OnPageChangeListener mPageChangeListener = new DefaultOnPageChangeListener(
            new CallbackOnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    Question question = mModelSurvey.getQuestions().get(position);
                    Log.i("PAGE_SCROLLED"
                            , String.format(Locale.getDefault(), "PAGE_SCROLLED %d.\n %s"
                                    , position, question.toString()));
                    mLastPosition = position;
                    enabledPages[position] = question.isCorrect();
                    mViewPager.setEnabled(enabledPages[position]);
                    if (position+1 == mModelSurvey.getQuestions().size()) {
                        tryEndSurvey();
                    }
                }

                @Override
                public void onPageSelected(int position) {
                    Question question = mModelSurvey.getQuestions().get(position);
                    Log.i("PAGE_SELECTED"
                            , String.format(Locale.getDefault(), "PAGE_SELECTED %d.\n %s"
                                    , position, question.toString()));
                    mViewPager.setEnabled(enabledPages[position]);
                    viewPagerIndicatorWithTextDot.selectMarker(position);
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    String str = "";
                    switch (state) {
                        case ViewPager.SCROLL_STATE_DRAGGING:
                            str = "SCROLL_STATE_DRAGGING";
                            break;
                        case ViewPager.SCROLL_STATE_IDLE:
                            str = "SCROLL_STATE_IDLE";
                            break;
                        case ViewPager.SCROLL_STATE_SETTLING:
                            str = "SCROLL_STATE_SETTLING";
                            break;
                    }
                    Log.i("PAGE_SCROLL_STATE", str);
                }
            }
        );

        mViewPager.addOnPageChangeListener(mPageChangeListener);
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(BUNDLE_SURVEY, mModelSurvey);
        outState.putInt(BUNDLE_LAST_POSITION, mLastPosition);
        outState.putBooleanArray(BUNDLE_ENABLED_PAGES, enabledPages);
        outState.putBoolean(BUNDLE_ALREADY_CALLING, alreadyCalling);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            mModelSurvey = savedInstanceState.getParcelable(BUNDLE_SURVEY);
            mLastPosition = savedInstanceState.getInt(BUNDLE_LAST_POSITION);
            enabledPages = savedInstanceState.getBooleanArray(BUNDLE_ENABLED_PAGES);
            alreadyCalling = savedInstanceState.getBoolean(BUNDLE_ALREADY_CALLING);
        }
    }

    @Override
    public void notifyObserverQuestion(Question question) {
        enabledPages[mLastPosition] = question.isCorrect();
        if (enabledPages[mLastPosition]) {
            String msg = String.format(Locale.getDefault()
                    , "Pergunta %d correta", mLastPosition + 1);
            Toast.makeText(getContext()
                    , msg
                    , Toast.LENGTH_SHORT).show();
        }
        mViewPager.setEnabled(enabledPages[mLastPosition]);
    }


    private boolean alreadyCalling = false;

    private void tryEndSurvey() {
        boolean flag = true;
        for (boolean f : enabledPages) {
            if(!f) {
                flag = false;
                break;
            }
        }
        /**
         * Se todas as perguntas foram respondidas corretamente podemos finalizar o formulario e fazer
         * qualquer coisa com os dados
         * */
        if (flag && ! alreadyCalling) {
            mModelSurvey.end();
            alreadyCalling = true;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
