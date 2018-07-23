package lib.view.stepform.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lib.view.stepform.R;
import lib.view.stepform.action.QuestionCallback;
import lib.view.stepform.models.Question;
import lib.view.stepform.models.Survey;
import lib.view.stepform.views.viewpager.adapter.DefaultStatePagerAdapter;
import lib.view.stepform.views.viewpager.animation.ScaleViewPageTransformer;
import lib.view.stepform.views.viewpager.callback.impl.DefaultCallbackPageChange;
import lib.view.stepform.views.viewpager.listener.DefaultOnPageListener;

public class FragmentSurvey extends Fragment {


    private Survey survey;

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private PagerTitleStrip mPagerTitleStrip;
    private ViewPager.PageTransformer mPageTransformer;
    private ViewPager.OnPageChangeListener mPageChangeListener;

    public FragmentSurvey() {}

    // TODO: Rename and change types and number of parameters
    public static FragmentSurvey newInstance(Survey survey) {
        FragmentSurvey fragment = new FragmentSurvey();
        fragment.survey = survey;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_survey, container, false);

        mViewPager = view.findViewById(R.id.view_pager);
        mPagerTitleStrip = view.findViewById(R.id.title);

        mPageTransformer = new ScaleViewPageTransformer();

        mViewPager.setPageTransformer(true, mPageTransformer);
        mPagerAdapter = new DefaultStatePagerAdapter(getFragmentManager(), survey.getQuestions());
        mViewPager.setAdapter(mPagerAdapter);

        mPageChangeListener = new DefaultOnPageListener(new DefaultCallbackPageChange(new QuestionCallback() {
            @Override
            public void onStart() {

            }

            @Override
            public void whenPassing(int nQuestion) {
                Question question = survey.getQuestions().get(nQuestion);
                Log.i("WHEN_PASSING", question.toString());
            }

            @Override
            public void whenSelecting(int nQuestion) {
                Question question = survey.getQuestions().get(nQuestion);
                Log.i("WHEN_SELECTING", question.toString());
            }

            @Override
            public void atTheEnd() {

            }

        }));

        mViewPager.addOnPageChangeListener(mPageChangeListener);

        return view;
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
