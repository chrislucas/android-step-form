package lib.view.stepform.models;

import android.support.annotation.LayoutRes;

import java.util.ArrayList;
import java.util.List;

import lib.view.stepform.models.options.Option;

public abstract class QuestionWithMultipleAnswer<T> extends Question<T> {

    public MultipleAnswer<T> multipleAnswer;

    public QuestionWithMultipleAnswer(String title, String text
            , @LayoutRes int layoutResource, List<Option<T>> options) {
        super(title, text, layoutResource, options);
        multipleAnswer = new MultipleAnswer<>();
    }

    public QuestionWithMultipleAnswer() {
        options = new ArrayList<>();
        multipleAnswer = new MultipleAnswer<>();
    }

    @Override
    public MultipleAnswer<T> getAnswer() {
        return multipleAnswer;
    }

    public List<Option<T>> getOptions() {
        return options;
    }
}
