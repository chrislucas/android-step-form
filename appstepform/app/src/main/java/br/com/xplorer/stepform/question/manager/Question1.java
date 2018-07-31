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

public class Question1 extends QuestionWithSingleAnswer<String> {

    private View viewRoot;

    private EditText textAnswer;

    private Question1(Parcel reader) {
        readerParcel(reader);
    }

    public Question1(String title, String text, int layoutRes) {
        super(title, text, layoutRes);
        getAnswer().setValue("");
    }

    public Question1(String title, String text, int layoutRes, List<Option<String>> list) {
        super(title, text, layoutRes, list);
        getAnswer().setValue("");
    }

    @Override
    public void setAnswer() {
        String data = textAnswer.getText().toString();
        if (data.isEmpty() || data.matches("\\s+")) {
            textAnswer.setError("Campo em branco.");
            textAnswer.requestFocus();
        }

        if (getAnswer() != null) {
            getAnswer().setValue(data);
        }

        if (getObserverQuestion() != null)
            getObserverQuestion().notify(Question1.this);
    }

    private boolean isNotEmpty(String in) {
        return in != null && ! in.equals("") && ! in.matches("\\s+");
    }

    private boolean confirm() {
        return getAnswer() != null && isNotEmpty(getAnswer().getValue());
    }

    @Override
    public void bindLayoutWithQuestion(Context context) {
        viewRoot = getViewRoot();
        if (viewRoot != null) {
            ( (TextView) viewRoot.findViewById(R.id.title_question_1))
                    .setText(getText());
            viewRoot.findViewById(R.id.confirm).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setAnswer();
                }
            });

            textAnswer = viewRoot.findViewById(R.id.text_answer_question_1);
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
        singleAnswer = (SingleAnswer<String>) reader.readValue(SingleAnswer.class.getClassLoader());
        text = reader.readString();
        title = reader.readString();
        layoutResource = reader.readInt();
    }

    public static final Creator<Question1> CREATOR = new Parcelable.Creator<Question1>() {
        @Override
        public Question1 createFromParcel(Parcel source) {
            return new Question1(source);
        }

        @Override
        public Question1[] newArray(int size) {
            return new Question1[size];
        }
    };

    @Override
    public boolean validate() {
        return confirm();
    }
}
