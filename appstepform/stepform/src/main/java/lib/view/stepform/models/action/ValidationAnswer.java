package lib.view.stepform.models.action;

import lib.view.stepform.models.Answer;

public interface ValidationAnswer<T>  {
    boolean validate(Answer<T> answer);
}
