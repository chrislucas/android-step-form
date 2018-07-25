package br.com.xplorer.stepform.question.manager;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import br.com.xplorer.stepform.MainActivity;
import br.com.xplorer.stepform.R;
import lib.view.stepform.action.ManagerLayoutQuestion;
import lib.view.stepform.models.Question;

public class ManagerQuestion2 implements ManagerLayoutQuestion {

    private Question question;
    private Context context;

    public ManagerQuestion2(Context context) {
        this.context = context;
    }

    @Override
    public void bindLayoutWithQuestion(Question question) {
        View viewRootQuestion = question.getView(context);
        if (viewRootQuestion != null) {
            ( (TextView) viewRootQuestion.findViewById(R.id.title_question_2))
                    .setText(question.getQuestionText());
        }
        this.question = question;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(question);
    }

    private ManagerQuestion2(Parcel reader) {
        readerToParcel(reader);
    }


    private void readerToParcel(Parcel reader) {
        question = (Question) reader.readValue(Question.class.getClassLoader());
    }


    public static final Parcelable.Creator<ManagerQuestion2> CREATOR = new Parcelable.Creator<ManagerQuestion2>() {
        @Override
        public ManagerQuestion2 createFromParcel(Parcel source) {
            return new ManagerQuestion2(source);
        }

        @Override
        public ManagerQuestion2[] newArray(int size) {
            return new ManagerQuestion2[size];
        }
    };


}
