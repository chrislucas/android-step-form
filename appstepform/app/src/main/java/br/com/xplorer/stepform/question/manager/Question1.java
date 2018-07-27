package br.com.xplorer.stepform.question.manager;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import br.com.xplorer.stepform.R;
import lib.view.stepform.models.SingleAnswer;
import lib.view.stepform.models.QuestionWithSingleAnswer;
import lib.view.stepform.models.options.Option;

public class Question1<T> extends QuestionWithSingleAnswer<T> {

    private View viewRoot;

    private Question1(Parcel reader) {
        readerParcel(reader);
    }

    public Question1(String title, String text, int layoutRes) {
        super(title, text, layoutRes);
    }

    public Question1(String title, String text, int layoutRes, List<Option<T>> list) {
        super(title, text, layoutRes, list);
    }

    private View.OnClickListener getOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               validate();
            }
        };
    }

    private boolean confirm() {
        EditText editText = viewRoot.findViewById(R.id.text_answer_question_1);
        String data = editText.getText().toString();
        if (data.isEmpty() || data.matches("\\s+")) {
            editText.setError("Campo em branco.");
            editText.requestFocus();
            return false;
        }
        if (getAnswer() != null)
            ((SingleAnswer<String>)getAnswer()).setValue(data);
        return true;
    }

    @Override
    public void bindLayoutWithQuestion(Context context) {
        viewRoot = getViewRoot();
        if (viewRoot != null) {
            ( (TextView) viewRoot.findViewById(R.id.title_question_1))
                    .setText(getText());
            viewRoot.findViewById(R.id.confirm).setOnClickListener(getOnClickListener());
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

    public static final Creator<Question1<?>> CREATOR = new Parcelable.Creator<Question1<?>>() {
        @Override
        public Question1<?> createFromParcel(Parcel source) {
            return new Question1(source);
        }

        @Override
        public Question1<?>[] newArray(int size) {
            return new Question1[size];
        }
    };

    @Override
    public boolean validate() {
        return confirm();
    }
}
