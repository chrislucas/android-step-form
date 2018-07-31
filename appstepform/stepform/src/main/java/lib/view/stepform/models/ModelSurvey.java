package lib.view.stepform.models;


import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import lib.view.stepform.action.SurveyCallback;

public final class ModelSurvey extends AbstractSurvey {

    public ModelSurvey(Context context, List<Question> questions, SurveyCallback surveyCallback) {
        super(context, questions, surveyCallback);
    }

    private ModelSurvey(Parcel reader) {
        readerParcel(reader);
    }

    public void end() {
        surveyCallback.atTheEnd();
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
