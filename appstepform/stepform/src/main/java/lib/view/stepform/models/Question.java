package lib.view.stepform.models;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;

import java.util.Locale;

import lib.view.stepform.models.action.ManagerLayoutQuestion;


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

    private ManagerLayoutQuestion managerLayoutQuestion;

    public Question(String questionText, @LayoutRes int layoutResource) {
        this.questionText = questionText;
        this.layoutResource = layoutResource;
    }

    public Question(ManagerLayoutQuestion managerLayoutQuestion, String questionText, @LayoutRes int layoutResource) {
        this(questionText, layoutResource);
        this.managerLayoutQuestion = managerLayoutQuestion;
        this.managerLayoutQuestion.manager(this);
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


    public View getView(Context context) {
        return LayoutInflater.from(context).inflate(layoutResource, null, false);
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
