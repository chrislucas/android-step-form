package br.com.xplorer.stepform.question.validation;


import lib.view.stepform.action.ValidateQuestion;

public class DefaultValidateQuestion<T> implements ValidateQuestion {

    @Override
    public void setAnswer() {}

    @Override
    public boolean validate() {
        return false;
    }
}
