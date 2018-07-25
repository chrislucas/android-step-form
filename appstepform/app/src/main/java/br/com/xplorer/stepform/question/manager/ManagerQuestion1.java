package br.com.xplorer.stepform.question.manager;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import br.com.xplorer.stepform.MainActivity;
import br.com.xplorer.stepform.R;
import lib.view.stepform.models.Question;
import lib.view.stepform.action.ManagerLayoutQuestion;

public class ManagerQuestion1 implements ManagerLayoutQuestion {

    private Question question;
    private Context context;

    public ManagerQuestion1(Context context) {
        this.context = context;
    }

    @Override
    public void bindLayoutWithQuestion(Question question) {
        View viewRoot = question.getView(context);
        if (viewRoot != null) {
            ( (TextView) viewRoot.findViewById(R.id.title_question_1))
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

    private void readerToParcel(Parcel reader) {
        question = (Question) reader.readValue(Question.class.getClassLoader());
    }

    private ManagerQuestion1(Parcel reader) {
        readerToParcel(reader);
    }

    public static final Parcelable.Creator<ManagerQuestion1> CREATOR =
            new Parcelable.Creator<ManagerQuestion1>() {
        @Override
        public ManagerQuestion1 createFromParcel(Parcel source) {
            return new ManagerQuestion1(source);
        }

        @Override
        public ManagerQuestion1[] newArray(int size) {
            return new ManagerQuestion1[size];
        }
    };
}
