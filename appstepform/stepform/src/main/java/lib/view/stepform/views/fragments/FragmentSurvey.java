package lib.view.stepform.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lib.view.stepform.R;
import lib.view.stepform.models.ModelSurvey;
import lib.view.stepform.views.viewpager.adapter.DefaultStatePagerAdapter;
import lib.view.stepform.views.viewpager.listener.DefaultOnPageChangeListener;

public class FragmentSurvey extends Fragment {

    private ModelSurvey mModelSurvey;

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private PagerTitleStrip mPagerTitleStrip;
    private ViewPager.OnPageChangeListener mPageChangeListener;

    private static final String BUNDLE_SURVEY = "BUNDLE_SURVEY";
    private static final String BUNDLE_LAST_POSITION = "BUNDLE_LAST_POSITION";

    private int mLastPosition = -1;

    public FragmentSurvey() {}

    // TODO: Rename and change types and number of parameters
    public static FragmentSurvey newInstance(ModelSurvey modelSurvey) {
        FragmentSurvey fragment = new FragmentSurvey();
        fragment.mModelSurvey = modelSurvey;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setRetainInstance(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_survey, container, false);

        if (savedInstanceState != null) {
            mModelSurvey = savedInstanceState.getParcelable(BUNDLE_SURVEY);
            mLastPosition = savedInstanceState.getInt(BUNDLE_LAST_POSITION);
        }

        mViewPager = view.findViewById(R.id.view_pager);
        mPagerTitleStrip = view.findViewById(R.id.title);

        mViewPager.setPageTransformer(true, mModelSurvey.pageTransformer());

        mPagerAdapter = new DefaultStatePagerAdapter(getFragmentManager(), mModelSurvey.getQuestions());
        mViewPager.setAdapter(mPagerAdapter);

        mPageChangeListener = new DefaultOnPageChangeListener(mModelSurvey
                , new DefaultOnPageChangeListener.CallbackOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                FragmentSurvey.this.mLastPosition = position;
            }
        });
        mViewPager.addOnPageChangeListener(mPageChangeListener);
        if (mLastPosition != -1) {
            mViewPager.setCurrentItem(mLastPosition, true);
        }
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(BUNDLE_SURVEY, mModelSurvey);
        outState.putInt(BUNDLE_LAST_POSITION, mLastPosition);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            mModelSurvey = savedInstanceState.getParcelable(BUNDLE_SURVEY);
            mLastPosition = savedInstanceState.getInt(BUNDLE_LAST_POSITION);
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
