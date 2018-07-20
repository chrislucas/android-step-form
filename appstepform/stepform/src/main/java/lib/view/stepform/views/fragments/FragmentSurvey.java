package lib.view.stepform.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lib.view.stepform.R;
import lib.view.stepform.models.Survey;

public class FragmentSurvey extends Fragment {


    private Survey survey;

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private PagerTitleStrip mPagerTitleStrip;
    private ViewPager.PageTransformer mPageTransformer;
    private ViewPager.OnPageChangeListener mPageChangeListener;

    public FragmentSurvey() {}

    // TODO: Rename and change types and number of parameters
    public static FragmentSurvey newInstance() {
        FragmentSurvey fragment = new FragmentSurvey();
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
        return inflater.inflate(R.layout.fragment_survey, container, false);
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
