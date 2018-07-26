package lib.view.stepform.models;


import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;

import java.util.ArrayList;
import java.util.List;

import lib.view.stepform.action.ManagerLayoutQuestion;
import lib.view.stepform.action.ValidationAnswer;
import lib.view.stepform.models.options.Option;

public abstract class MultipleQuestion<T> extends Question<T> {

    public MultipleAnswer<T> multipleAnswer;

    public MultipleQuestion(ValidationAnswer<T> validationAnswer, String questionText
            , @LayoutRes int layoutResource, List<Option<T>> options) {
        super(validationAnswer, questionText, layoutResource, options);
    }

    public MultipleQuestion() {
        options = new ArrayList<>();
    }

    private MultipleQuestion(Parcel reader) {
        this();
    }

    @Override
    public Answer<T> getAnswer() {
        return multipleAnswer;
    }

    @Override
    public void setAnswer(Answer<T> answer) {
        this.multipleAnswer = (MultipleAnswer<T>) answer;
    }

    public List<Option<T>> getOptions() {
        return options;
    }
}
