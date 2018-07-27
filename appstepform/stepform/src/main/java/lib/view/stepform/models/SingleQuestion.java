package lib.view.stepform.models;

import android.support.annotation.LayoutRes;

import java.util.List;

import lib.view.stepform.models.options.Option;

public abstract class SingleQuestion<T> extends Question<T> {

    protected SingleAnswer<T> singleAnswer;

    protected SingleQuestion() {}

    public SingleQuestion(String title, String text , @LayoutRes int layoutRes) {
        super(text, title, layoutRes);
    }

    public SingleQuestion(String title, String text, @LayoutRes int layoutRes, List<Option<T>> options) {
        super(title, text, layoutRes, options);
    }

    @Override
    public Answer<T> getAnswer() {
        return singleAnswer;
    }

    @Override
    public void setAnswer(Answer answer) {
        this.singleAnswer = (SingleAnswer<T>) answer;
    }
}
