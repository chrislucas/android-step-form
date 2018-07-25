package br.com.xplorer.stepform.question.validation;

import android.support.annotation.Nullable;

import lib.view.stepform.action.ValidationAnswer;
import lib.view.stepform.models.Answer;

public class DefaultValidationAnswer<T> implements ValidationAnswer<T> {

    @Override
    public boolean validate(@Nullable Answer<T> answer) {
        return false;
    }
}
