package br.com.xplorer.stepform.question.manager;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import br.com.xplorer.stepform.R;
import lib.view.stepform.action.ValidationAnswer;
import lib.view.stepform.models.SingleAnswer;
import lib.view.stepform.models.SingleQuestion;
import lib.view.stepform.models.options.Option;

public class Question1<T> extends SingleQuestion<T> {

    private Context context;

    private Question1(Parcel reader) {
        readerParcel(reader);
    }

    public Question1(ValidationAnswer<T> validationAnswer, String questionText, int layoutRes, Context context) {
        super(validationAnswer, questionText, layoutRes);
        this.context = context;
    }

    public Question1(ValidationAnswer<T> validationAnswer, String questionText, int layoutRes, List<Option<T>> list, Context context) {
        super(validationAnswer, questionText, layoutRes, list);
        this.context = context;
    }

    @Override
    public void bindLayoutWithQuestion() {
        View viewRoot = getViewRoot();
        if (viewRoot != null) {
            ( (TextView) viewRoot.findViewById(R.id.title_question_1))
                    .setText(getQuestionText());
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(singleAnswer);
        dest.writeString(questionText);
        dest.writeInt(layoutResource);
    }

    private void readerParcel(Parcel reader) {
        singleAnswer = (SingleAnswer<T>) reader.readValue(SingleAnswer.class.getClassLoader());
        questionText = reader.readString();
        layoutResource = reader.readInt();
    }

    public static final Parcelable.Creator<Question1> CREATOR = new Parcelable.Creator<Question1>() {
        @Override
        public Question1 createFromParcel(Parcel source) {
            return new Question1(source);
        }

        @Override
        public Question1[] newArray(int size) {
            return new Question1[size];
        }
    };
}
