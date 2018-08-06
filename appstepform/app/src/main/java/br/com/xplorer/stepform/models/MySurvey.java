package br.com.xplorer.stepform.models;

import android.os.Parcel;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.List;

import lib.view.stepform.action.SurveyCallback;
import lib.view.stepform.models.AbstractSurvey;
import lib.view.stepform.models.Question;

public class MySurvey extends AbstractSurvey {

    public MySurvey(FragmentActivity fragmentActivity, List<Question> questions, SurveyCallback surveyCallback, @IdRes int res) {
        super(fragmentActivity, questions, surveyCallback, res);
    }

    public MySurvey(Parcel reader) {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    @Override
    public ViewPager.PageTransformer pageTransformer() {
        return super.pageTransformer();
    }

    @Override
    public void end() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MySurvey> CREATOR = new Creator<MySurvey>() {
        @Override
        public MySurvey createFromParcel(Parcel source) {
            return new MySurvey(source);
        }

        @Override
        public MySurvey[] newArray(int size) {
            return new MySurvey[size];
        }
    };
}
