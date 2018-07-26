package br.com.xplorer.stepform.question.manager;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import br.com.xplorer.stepform.R;
import lib.view.stepform.action.ValidationAnswer;

import lib.view.stepform.models.SingleAnswer;
import lib.view.stepform.models.SingleQuestion;
import lib.view.stepform.models.options.Option;

public class Question4<T> extends SingleQuestion<T> {

    private Context context;

    private Question4(Parcel reader) {
        readerParcel(reader);
    }

    public Question4(ValidationAnswer<T> validationAnswer, String questionText, int layoutRes, Context context) {
        super(validationAnswer, questionText, layoutRes);
        this.context = context;
    }

    public Question4(ValidationAnswer<T> validationAnswer, String questionText, int layoutRes, List<Option<T>> options, Context context) {
        super(validationAnswer, questionText, layoutRes, options);
        this.context = context;
    }

    @Override
    public void bindLayoutWithQuestion() {
        View viewRoot = getViewRoot();
        if (viewRoot != null) {
            ((TextView) viewRoot.findViewById(R.id.title_question_4))
                    .setText(getQuestionText());
            RadioGroup radioGroup = viewRoot.findViewById(R.id.group_roles);
            int acc = 0;
            for (Option<T> op :getOptions()) {
                AppCompatRadioButton radioButton = new AppCompatRadioButton(context);
                radioButton.setText(op.getDescription());
                LinearLayout.LayoutParams layoutParams =
                        new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                                , ViewGroup.LayoutParams.WRAP_CONTENT);

                radioButton.setLayoutParams(layoutParams);
                radioGroup.addView(radioButton, acc++);
            }
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
        dest.writeList(options);
    }

    private void readerParcel(Parcel reader) {
        singleAnswer = (SingleAnswer<T>) reader.readValue(SingleAnswer.class.getClassLoader());
        questionText = reader.readString();
        layoutResource = reader.readInt();
        reader.readList(options, Option.class.getClassLoader());
    }

    public static final Parcelable.Creator<Question4> CREATOR = new Parcelable.Creator<Question4>() {
        @Override
        public Question4 createFromParcel(Parcel source) {
            return new Question4(source);
        }

        @Override
        public Question4[] newArray(int size) {
            return new Question4[size];
        }
    };

}
