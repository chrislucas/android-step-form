package lib.view.stepform.models;

import android.os.Parcelable;
import android.support.annotation.LayoutRes;

import java.util.Locale;


/**
 * Classe que representa uma pergunta de um questionario.
 *
 * Num questionario podemos ter perguntas que aceitam multiplas respostas ou respostas unicas
 *
 *
 *
 * */

public abstract class Question<T> implements Parcelable {

    protected Answer<T> answer;
    protected final String questionText;

    @LayoutRes
    protected final int layoutResource;

    public Question(String questionText, @LayoutRes int layoutResource) {
        this.questionText = questionText;
        this.layoutResource = layoutResource;
    }

    public String getQuestionText() {
        return questionText;
    }

    public abstract Answer<T> getAnswer();

    public abstract void setAnswer(Answer<T> answer);

    public boolean isCorrect() {
        return answer.validate();
    }

    public int getLayoutResource() {
        return layoutResource;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault()
                , "Question: %s.\nAnswer: %s\nAnswer: %s"
                , questionText
                , answer.toString()
                , isCorrect() ? "Correct" : "Incorrect"
        );
    }
}
