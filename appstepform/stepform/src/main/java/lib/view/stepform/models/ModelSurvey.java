package lib.view.stepform.models;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import lib.view.stepform.action.QuestionCallback;
import lib.view.stepform.views.activity.ActivitySurvey;
import lib.view.stepform.views.viewpager.transformer.ScaleViewPageTransformer;


public class ModelSurvey implements Parcelable, QuestionCallback {

    private List<Question> questions;

    public ModelSurvey(List<Question> questions) {
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

    private ModelSurvey(Parcel reader) {
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

    @Override
    public void onStart() {

    }

    @Override
    public boolean validateWhenPassing(int nQuestion) {
        Question question = questions.get(nQuestion);
        Log.i("WHEN_PASSING", question.toString());
        return question.validate();
    }

    @Override
    public void whenSelecting(int nQuestion) {
        Question question = questions.get(nQuestion);
        Log.i("WHEN_SELECTING", question.toString());
    }

    @Override
    public void atTheEnd() {

    }

    public ViewPager.PageTransformer pageTransformer() {
        return new ScaleViewPageTransformer();
    }
}
