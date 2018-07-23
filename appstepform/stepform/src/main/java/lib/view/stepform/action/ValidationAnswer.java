package lib.view.stepform.action;

import android.support.annotation.Nullable;

import lib.view.stepform.models.Answer;

public interface ValidationAnswer<T>  {
    boolean validate(@Nullable Answer<T> answer);
}
