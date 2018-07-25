package lib.view.stepform.action;


import android.os.Parcelable;

import lib.view.stepform.models.Question;

public interface ManagerLayoutQuestion extends Parcelable {
    void bindLayoutWithQuestion(Question question);
}
