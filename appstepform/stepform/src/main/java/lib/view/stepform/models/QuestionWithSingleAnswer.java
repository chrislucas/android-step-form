package lib.view.stepform.models;

import android.support.annotation.LayoutRes;

import java.util.List;

import lib.view.stepform.models.options.Option;

public abstract class QuestionWithSingleAnswer<T> extends Question<T> {

    protected SingleAnswer<T> singleAnswer;

    protected QuestionWithSingleAnswer() {
        singleAnswer = new SingleAnswer<>();
    }

    public QuestionWithSingleAnswer(String title, String text , @LayoutRes int layoutRes) {
        super(text, title, layoutRes);
        singleAnswer = new SingleAnswer<>();
    }

    public QuestionWithSingleAnswer(String title, String text, @LayoutRes int layoutRes, List<Option<T>> options) {
        super(title, text, layoutRes, options);
        singleAnswer = new SingleAnswer<>();
    }

    @Override
    public SingleAnswer<T> getAnswer() {
        return singleAnswer;
    }
}
