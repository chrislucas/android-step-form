package br.com.xplorer.stepform.question.validation;


import lib.view.stepform.action.QuestionCallback;

public class DefaultQuestionCallback<T> implements QuestionCallback {

    @Override
    public void setAnswer() {}

    @Override
    public boolean isCorrect() {
        return false;
    }
}
