package lib.view.stepform.models;



import android.support.annotation.LayoutRes;

import java.util.List;

import lib.view.stepform.action.ValidationAnswer;
import lib.view.stepform.models.options.Option;

public abstract class SingleQuestion<T> extends Question<T> {

    protected SingleAnswer<T> singleAnswer;


    protected SingleQuestion() {}


    public SingleQuestion(ValidationAnswer<T> validationAnswer,  String questionText, @LayoutRes int layoutRes) {
        super(validationAnswer, questionText, layoutRes);
    }

    public SingleQuestion(ValidationAnswer<T> validationAnswer, String questionText, @LayoutRes int layoutRes, List<Option<T>> options) {
        super(validationAnswer, questionText, layoutRes, options);
    }

    @Override
    public Answer<T> getAnswer() {
        return singleAnswer;
    }

    @Override
    public void setAnswer(Answer answer) {
        this.singleAnswer = (SingleAnswer<T>) answer;
    }



    @Override
    protected boolean validate() {
        return validation != null && validation.validate(answer);
    }

    @Override
    public void bindLayoutWithQuestion() {}
}
