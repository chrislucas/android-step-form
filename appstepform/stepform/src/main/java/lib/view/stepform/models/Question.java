package lib.view.stepform.models;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;

import java.util.List;
import java.util.Locale;

import lib.view.stepform.action.ManagerLayoutQuestion;
import lib.view.stepform.action.ValidationQuestion;
import lib.view.stepform.models.options.Option;


/**
 * Classe que representa uma pergunta de um questionario.
 *
 * Num questionario podemos ter perguntas que aceitam multiplas respostas ou respostas unicas
 *
 *
 *
 * */

public abstract class Question<T> implements Parcelable
        , ManagerLayoutQuestion<T>, ValidationQuestion<T> {

    // Resposta
    public Answer<T> answer;
    // Texto da pergunta
    public String text, title;

    // Possivel lista de opcoes casp a pergunta for objetiva
    public List<Option<T>> options;

    protected Question() { }

    @LayoutRes
    protected int layoutResource;

    protected View viewRoot;

    public Question(String title, String text, @LayoutRes int layoutResource) {
        this.text = text;
        this.title = title;
        this.layoutResource = layoutResource;
    }

    public Question(String title, String text, @LayoutRes int layoutResource, List<Option<T>> options) {
        this.text = text;
        this.title = title;

        this.layoutResource = layoutResource;
        this.options = options;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public abstract Answer<T> getAnswer();

    public abstract void setAnswer(Answer<T> answer);

    public boolean isCorrect() {
        return true;
    }

    public int getLayoutResource() {
        return layoutResource;
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
                , text
                , isCorrect() ? "Correct" : "Incorrect"
        );
    }
}
