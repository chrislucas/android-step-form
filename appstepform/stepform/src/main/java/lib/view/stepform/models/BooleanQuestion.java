package lib.view.stepform.models;


import java.util.List;

import lib.view.stepform.models.options.Option;

public abstract class BooleanQuestion extends Question<Boolean> {

    protected SingleAnswer<Boolean> singleAnswer;

    public BooleanQuestion() {
        singleAnswer = new SingleAnswer<>();
    }

    public BooleanQuestion(String title, String text, int layoutResource) {
        super(title, text, layoutResource);
        singleAnswer = new SingleAnswer<>();
    }

    public BooleanQuestion(String title, String text, int layoutResource, List<Option<Boolean>> options) {
        super(title, text, layoutResource, options);
        singleAnswer = new SingleAnswer<>();

    }
    @Override
    public SingleAnswer<Boolean> getAnswer() {
        return singleAnswer;
    }
}
