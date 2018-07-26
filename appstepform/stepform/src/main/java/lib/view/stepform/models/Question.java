package lib.view.stepform.models;

import android.content.Context;
import android.os.Parcel;
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

public abstract class Question<T> implements Parcelable, ManagerLayoutQuestion {

    // Resposta
    public Answer<T> answer;
    // Texto da pergunta
    public String questionText;

    // Comportamento de validacao da pergunta
    public ValidationAnswer<T> validation;

    // Possivel lista de opcoes casp a pergunta for objetiva
    public List<Option<T>> options;

    protected Question() { }

    protected abstract boolean validate();

    @LayoutRes
    protected int layoutResource;


    protected View viewRoot;


    public Question(ValidationAnswer<T> validation, String questionText, @LayoutRes int layoutResource) {
        this.questionText = questionText;
        this.layoutResource = layoutResource;
        this.validation = validation;
    }

    public Question(ValidationAnswer<T> validation, String questionText, @LayoutRes int layoutResource, List<Option<T>> options) {
        this.questionText = questionText;
        this.layoutResource = layoutResource;
        this.validation = validation;
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

    public Question inflate(Context context) {
        this.viewRoot = LayoutInflater.from(context).inflate(layoutResource, null, false);
        return this;
    }

    public View getViewRoot() {
        return viewRoot;
    }

    public List<Option<T>> getOptions() {
        return options;
    }
    @Override
    public String toString() {
        return String.format(Locale.getDefault()
                , "Question: %s.\nAnswer: %s"
                , questionText
                , isCorrect() ? "Correct" : "Incorrect"
        );
    }
}
