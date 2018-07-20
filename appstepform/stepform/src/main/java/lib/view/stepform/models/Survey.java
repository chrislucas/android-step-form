package lib.view.stepform.models;



import android.content.Context;
import android.content.Intent;
import java.util.List;

import lib.view.stepform.views.activity.ActivitySurvey;


public class Survey {

    private List<Question> questions;

    public Survey(List<Question> questions) {
        this.questions = questions;
    }

    public void start(Context context) {
        Intent intent = new Intent(context, ActivitySurvey.class);
    }
}
