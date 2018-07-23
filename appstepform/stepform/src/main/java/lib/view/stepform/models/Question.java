package lib.view.stepform.models;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;

import java.util.List;
import java.util.Locale;

import lib.view.stepform.action.ManagerLayoutQuestion;
import lib.view.stepform.action.ValidationAnswer;
import lib.view.stepform.models.options.Option;


/**
 * Classe que representa uma pergunta de um questionario.
 *
 * Num questionario podemos ter perguntas que aceitam multiplas respostas ou respostas unicas
 *
 *
 *
 * */

public abstract class Question<T> implements Parcelable {

    // Resposta
    protected Answer<T> answer;
    // Texto da pergunta
    protected String questionText;

    // Comportamento de validacao da pergunta
    protected ValidationAnswer<T> validation;

    // Possivel lista de opcoes casp a pergunta for objetiva
    protected List<Option<T>> options;

    protected Question() { }

    protected abstract boolean validate();

    @LayoutRes
    protected int layoutResource;

    protected ManagerLayoutQuestion managerLayoutQuestion;

    public Question(ManagerLayoutQuestion managerLayoutQuestion
            , ValidationAnswer<T> validation, String questionText, @LayoutRes int layoutResource) {
        this.questionText = questionText;
        this.layoutResource = layoutResource;
        this.managerLayoutQuestion = managerLayoutQuestion;
        this.validation = validation;
        this.managerLayoutQuestion.bindLayoutWithQuestion(this);
    }

    public Question(ManagerLayoutQuestion managerLayoutQuestion
            , ValidationAnswer<T> validation, String questionText, @LayoutRes int layoutResource, List<Option<T>> options) {
        this(managerLayoutQuestion, validation, questionText, layoutResource);
        this.options = options;
    }

    public String getQuestionText() {
        return questionText;
    }

    public abstract Answer<T> getAnswer();

    public abstract void setAnswer(Answer<T> answer);

    public boolean isCorrect() {
        return validate();
    }

    public int getLayoutResource() {
        return layoutResource;
    }

    public ValidationAnswer<T> getValidation() {
        return validation;
    }

    public ManagerLayoutQuestion getManagerLayoutQuestion() {
        return managerLayoutQuestion;
    }

    public View getView(Context context) {
        return LayoutInflater.from(context).inflate(layoutResource, null, false);
    }

    public List<Option<T>> getOptions() {
        return options;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault()
                , "Question: %s.\nAnswer: %s\nAnswer: %s"
                , questionText
                , answer == null ? "Undefined" : answer.toString()
                , isCorrect() ? "Correct" : "Incorrect"
        );
    }
}
