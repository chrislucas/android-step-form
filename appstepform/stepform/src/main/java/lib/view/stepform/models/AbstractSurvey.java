package lib.view.stepform.models;

import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import java.util.List;

import lib.view.stepform.action.SurveyCallback;
import lib.view.stepform.views.fragments.FragmentSurvey;
import lib.view.stepform.views.viewpager.transformer.ScaleViewPageTransformer;

public abstract class AbstractSurvey implements Parcelable {
    protected List<Question> questions;

    protected SurveyCallback surveyCallback;

    transient protected FragmentActivity fragmentActivity;

    protected ViewPager.PageTransformer mPageTransformer = new ScaleViewPageTransformer();

    protected AbstractSurvey() {}

    @IdRes
    protected int idResourceLayout;

    public AbstractSurvey(FragmentActivity fragmentActivity, List<Question> questions
            , SurveyCallback surveyCallback, @IdRes int idResourceLayout) {
        this.questions = questions;
        this.fragmentActivity = fragmentActivity;
        this.surveyCallback = surveyCallback;
        this.idResourceLayout = idResourceLayout;
    }


    public final void start() {
        surveyCallback.beforeStart();
        FragmentManager fm = fragmentActivity.getSupportFragmentManager();
        if (fm != null) {
            String tag = FragmentSurvey.class.getSimpleName();
            if (fm.findFragmentByTag(tag) == null) {
                fm.beginTransaction()
                        .replace(idResourceLayout, FragmentSurvey.newInstance(this), tag)
                        .addToBackStack(tag)
                        .commit();
            }
        }
    }

    public abstract void end();

    public List<Question> getQuestions() {
        return questions;
    }

    public SurveyCallback getSurveyCallback() {
        return surveyCallback;
    }

    public void setSurveyCallback(SurveyCallback surveyCallback) {
        this.surveyCallback = surveyCallback;
    }

    public void setPageTransformer(ViewPager.PageTransformer mPageTransformer) {
        this.mPageTransformer = mPageTransformer;
    }

    public ViewPager.PageTransformer pageTransformer() {
        return this.mPageTransformer;
    }
}
