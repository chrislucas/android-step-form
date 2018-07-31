package lib.view.stepform.models;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import lib.view.stepform.action.SurveyCallback;
import lib.view.stepform.views.activity.ActivitySurvey;
import lib.view.stepform.views.viewpager.transformer.ScaleViewPageTransformer;

public abstract class AbstractSurvey implements Parcelable {
    protected List<Question> questions;

    protected SurveyCallback surveyCallback;

    transient protected Context context;

    protected ViewPager.PageTransformer mPageTransformer = new ScaleViewPageTransformer();

    protected AbstractSurvey() {}

    public AbstractSurvey(Context context, List<Question> questions, SurveyCallback surveyCallback) {
        this.questions = questions;
        this.surveyCallback = surveyCallback;
        this.context = context;
    }

    public final void start() {
        surveyCallback.beforeStart();
        Intent intent = new Intent(context, ActivitySurvey.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(ActivitySurvey.BUNDLE_SURVEY, this);
        intent.putExtras(bundle);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
        if (context instanceof FragmentActivity) {
            ( (AppCompatActivity) context).finish();
        }
    }

    public abstract void end();

    public List<Question> getQuestions() {
        return questions;
    }

    public SurveyCallback getSurveyCallback() {
        return surveyCallback;
    }

    public void setPageTransformer(ViewPager.PageTransformer mPageTransformer) {
        this.mPageTransformer = mPageTransformer;
    }

    public ViewPager.PageTransformer pageTransformer() {
        return this.mPageTransformer;
    }
}
