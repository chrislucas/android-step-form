package br.com.xplorer.stepform.models;

import android.content.Context;
import android.os.Parcel;
import android.support.v4.view.ViewPager;

import java.util.List;

import lib.view.stepform.action.SurveyCallback;
import lib.view.stepform.models.AbstractSurvey;
import lib.view.stepform.models.Question;

public class MySurvey extends AbstractSurvey {

    public MySurvey(Context context, List<Question> questions, SurveyCallback surveyCallback) {
        super(context, questions, surveyCallback);
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
