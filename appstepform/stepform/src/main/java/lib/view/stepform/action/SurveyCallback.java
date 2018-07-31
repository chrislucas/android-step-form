package lib.view.stepform.action;

import java.io.Serializable;

public interface SurveyCallback extends Serializable {
    void beforeStart();
    void atTheEnd();
}
