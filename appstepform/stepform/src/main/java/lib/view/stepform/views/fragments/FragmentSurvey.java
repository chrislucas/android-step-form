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

    private ModelSurvey modelSurvey;

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private PagerTitleStrip mPagerTitleStrip;
    private ViewPager.OnPageChangeListener mPageChangeListener;

    private static final String BUNDLE_SURVEY = "BUNDLE_SURVEY";

    public FragmentSurvey() {}

    // TODO: Rename and change types and number of parameters
    public static FragmentSurvey newInstance(ModelSurvey modelSurvey) {
        FragmentSurvey fragment = new FragmentSurvey();
        fragment.modelSurvey = modelSurvey;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_survey, container, false);

        mViewPager = view.findViewById(R.id.view_pager);
        mPagerTitleStrip = view.findViewById(R.id.title);

        mViewPager.setPageTransformer(true, modelSurvey.pageTransformer());

        mPagerAdapter = new DefaultStatePagerAdapter(getFragmentManager(), modelSurvey.getQuestions());
        mViewPager.setAdapter(mPagerAdapter);

        mPageChangeListener = new DefaultOnPageChangeListener(modelSurvey);
        mViewPager.addOnPageChangeListener(mPageChangeListener);
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(BUNDLE_SURVEY, modelSurvey);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            modelSurvey = savedInstanceState.getParcelable(BUNDLE_SURVEY);
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
