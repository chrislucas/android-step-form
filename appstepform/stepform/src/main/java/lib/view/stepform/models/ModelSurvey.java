package lib.view.stepform.models;


import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import lib.view.stepform.action.SurveyCallback;

public final class ModelSurvey extends AbstractSurvey {

    public ModelSurvey(FragmentActivity fragmentActivity, List<Question> questions
            , SurveyCallback surveyCallback, @IdRes int idResourceLayout) {
        super(fragmentActivity, questions, surveyCallback, idResourceLayout);
    }

    private ModelSurvey(Parcel reader) {
        readerParcel(reader);
    }

    public void end() {
        if (surveyCallback != null)
            surveyCallback.atTheEnd();
        else {
            Log.e("END_SURVEY_CB_NOT_FOUND", "callback to finish survey not found");
        }
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(questions);
        dest.writeSerializable(surveyCallback);
    }

    private void readerParcel(Parcel reader) {
        if (questions == null)
            questions = new ArrayList<>();
        reader.readList(questions, Question.class.getClassLoader());
        surveyCallback = (SurveyCallback) reader.readSerializable();
    }

    public static final Parcelable.Creator<ModelSurvey> CREATOR = new Parcelable.Creator<ModelSurvey>() {
        @Override
        public ModelSurvey createFromParcel(Parcel source) {
            return new ModelSurvey(source);
        }

        @Override
        public ModelSurvey[] newArray(int size) {
            return new ModelSurvey[size];
        }
    };

}
