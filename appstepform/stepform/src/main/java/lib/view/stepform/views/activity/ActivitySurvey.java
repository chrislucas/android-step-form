package lib.view.stepform.views.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import lib.view.stepform.R;
import lib.view.stepform.models.ModelSurvey;
import lib.view.stepform.views.fragments.FragmentSurvey;

public class ActivitySurvey extends AppCompatActivity {


    public static final String BUNDLE_SURVEY = "BUNDLE_SURVEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                ModelSurvey modelSurvey = bundle.getParcelable(BUNDLE_SURVEY);
                if (modelSurvey != null)
                    loadFragment(modelSurvey);
            }
        }
    }

    private <T> void loadFragment(ModelSurvey modelSurvey) {
        FragmentManager fm = getSupportFragmentManager();
        if (fm != null) {
            fm.beginTransaction()
                    .replace(R.id.place_to_replace, FragmentSurvey.newInstance(modelSurvey))
                    .commit();
        }
    }
}
