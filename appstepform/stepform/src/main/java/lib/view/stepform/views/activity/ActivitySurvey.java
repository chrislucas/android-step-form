package lib.view.stepform.views.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import lib.view.stepform.R;
import lib.view.stepform.models.AbstractSurvey;
import lib.view.stepform.models.ModelSurvey;
import lib.view.stepform.views.fragments.FragmentSurvey;

public class ActivitySurvey extends AppCompatActivity {

    public static final String BUNDLE_SURVEY = "BUNDLE_SURVEY";

    private AbstractSurvey modelSurvey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        modelSurvey = null;
        if (savedInstanceState != null) {
            modelSurvey = savedInstanceState.getParcelable(BUNDLE_SURVEY);
        }
        else {
            Intent intent = getIntent();
            if (intent != null) {
                Bundle bundle = intent.getExtras();
                if (bundle != null) {
                    modelSurvey = bundle.getParcelable(BUNDLE_SURVEY);
                }
            }
        }
        if (modelSurvey != null)
            loadFragment(modelSurvey);
    }

    private void loadFragment(AbstractSurvey modelSurvey) {
        FragmentManager fm = getSupportFragmentManager();
        if (fm != null) {
            String tag = FragmentSurvey.class.getSimpleName();
            if (fm.findFragmentByTag(tag) == null) {
                fm.beginTransaction()
                        .replace(R.id.place_to_replace, FragmentSurvey.newInstance(modelSurvey), tag)
                        .addToBackStack(tag)
                        .commit();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (outState != null) {
            outState.putParcelable(BUNDLE_SURVEY, modelSurvey);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            modelSurvey = savedInstanceState.getParcelable(BUNDLE_SURVEY);
        }
    }
}
