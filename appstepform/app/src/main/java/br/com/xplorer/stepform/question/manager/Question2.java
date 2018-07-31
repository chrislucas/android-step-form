package br.com.xplorer.stepform.question.manager;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

import br.com.xplorer.stepform.R;
import lib.view.stepform.models.BooleanQuestion;
import lib.view.stepform.models.SingleAnswer;
import lib.view.stepform.models.options.Option;

public class Question2 extends BooleanQuestion {

    private Question2(Parcel reader) {
        readerParcel(reader);
    }

    public Question2(String title, String text, int layoutRes) {
        super(title, text, layoutRes);
    }

    public Question2(String title, String text, int layoutRes, List<Option<Boolean>> options) {
        super(title, text, layoutRes, options);
    }

    @Override
    public void bindLayoutWithQuestion(Context context) {
        View viewRootQuestion = getViewRoot();
        if (viewRootQuestion != null) {
            ( (TextView) viewRootQuestion.findViewById(R.id.title_question_2))
                    .setText(getText());
            Switch mSwitch = viewRootQuestion.findViewById(R.id.switch_question_2);

            if (getAnswer() != null) {
                Boolean s = getAnswer().getValue();
                if (s != null) {
                    mSwitch.setChecked(s);
                    mSwitch.setText(s ? mSwitch.getTextOn() : mSwitch.getTextOff());
                }
            }

            mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    buttonView.setText(isChecked ? ((Switch) buttonView).getTextOn() : ((Switch) buttonView).getTextOff()) ;
                    getAnswer().setValue(isChecked);
                    if (getObserverQuestion() != null)
                        getObserverQuestion().notify(Question2.this);
                }
            });
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
        singleAnswer = (SingleAnswer<Boolean>) reader.readValue(SingleAnswer.class.getClassLoader());
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
        return getAnswer().getValue() != null;
    }
}
