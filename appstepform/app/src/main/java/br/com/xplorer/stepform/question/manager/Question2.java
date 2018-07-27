package br.com.xplorer.stepform.question.manager;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import br.com.xplorer.stepform.R;
import lib.view.stepform.models.SingleAnswer;
import lib.view.stepform.models.SingleQuestion;
import lib.view.stepform.models.options.Option;

public class Question2<T> extends SingleQuestion<T> {


    private Question2(Parcel reader) {
        readerParcel(reader);
    }

    public Question2(String title, String text, int layoutRes) {
        super(title, text, layoutRes);
    }

    public Question2(String title, String text, int layoutRes, List<Option<T>> options) {
        super(title, text, layoutRes, options);
    }

    @Override
    public void bindLayoutWithQuestion(Context context) {
        View viewRootQuestion = getViewRoot();
        if (viewRootQuestion != null) {
            ( (TextView) viewRootQuestion.findViewById(R.id.title_question_2))
                    .setText(getText());
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(singleAnswer);
        dest.writeString(text);
        dest.writeString(title);
        dest.writeInt(layoutResource);
    }

    private void readerParcel(Parcel reader) {
        singleAnswer = (SingleAnswer<T>) reader.readValue(SingleAnswer.class.getClassLoader());
        text = reader.readString();
        title = reader.readString();
        layoutResource = reader.readInt();
    }

    public static final Parcelable.Creator<Question2> CREATOR = new Parcelable.Creator<Question2>() {
        @Override
        public Question2 createFromParcel(Parcel source) {
            return new Question2(source);
        }

        @Override
        public Question2[] newArray(int size) {
            return new Question2[size];
        }
    };

    @Override
    public boolean validate() {
        return false;
    }
}
