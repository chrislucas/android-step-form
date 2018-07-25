package lib.view.stepform.models;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import lib.view.stepform.views.activity.ActivitySurvey;



public class Survey implements Parcelable {

    private List<Question> questions;

    public Survey(List<Question> questions) {
        this.questions = questions;
    }

    public void start(Context context) {
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

    public List<Question> getQuestions() {
        return questions;
    }

    private Survey(Parcel reader) {
        readerParcel(reader);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(questions);
    }

    private void readerParcel(Parcel reader) {
        if (questions == null)
            questions = new ArrayList<>();
        reader.readList(questions, Question.class.getClassLoader());
    }

    public static final Parcelable.Creator<Survey> CREATOR = new Parcelable.Creator<Survey>() {
        @Override
        public Survey createFromParcel(Parcel source) {
            return new Survey(source);
        }

        @Override
        public Survey[] newArray(int size) {
            return new Survey[size];
        }
    };
}
