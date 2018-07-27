package br.com.xplorer.stepform.question.validation;


import lib.view.stepform.action.ValidationQuestion;

public class DefaultValidationQuestion<T> implements ValidationQuestion<T> {

    @Override
    public boolean validate() {
        return false;
    }
}
