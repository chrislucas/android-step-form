package br.com.xplorer.stepform.models;

import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

import lib.view.stepform.models.ModelSurvey;
import lib.view.stepform.models.Question;

public class MySurvey extends ModelSurvey {

    public MySurvey(List<Question> questions) {
        super(questions);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public boolean validateWhenPassing(int nQuestion) {
        return super.validateWhenPassing(nQuestion);
    }

    @Override
    public void whenSelecting(int nQuestion) {
        super.whenSelecting(nQuestion);
    }

    @Override
    public void atTheEnd() {
        super.atTheEnd();
    }

    @Override
    public ViewPager.PageTransformer pageTransformer() {
        return super.pageTransformer();
    }
}
