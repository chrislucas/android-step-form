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

import java.util.ArrayList;
import java.util.List;

import br.com.xplorer.stepform.R;

import br.com.xplorer.stepform.models.Role;
import lib.view.stepform.models.QuestionWithSingleAnswer;
import lib.view.stepform.models.SingleAnswer;
import lib.view.stepform.models.options.Option;

public class Question4 extends QuestionWithSingleAnswer<Role> {

    private boolean userInteract = false;

    private Question4(Parcel reader) {
        readerParcel(reader);
    }

    public Question4(String title, String text, int layoutRes) {
        super(title, text, layoutRes);
    }

    public Question4(String title, String text, int layoutRes, List<Option<Role>> options) {
        super(title, text, layoutRes, options);
    }

    @Override
    public void bindLayoutWithQuestion(final Context context) {
        View viewRoot = getViewRoot();
        if (viewRoot != null) {
            ((TextView) viewRoot.findViewById(R.id.title_question_4))
                    .setText(getText());
            RadioGroup radioGroup = viewRoot.findViewById(R.id.group_roles);
            int acc = 0;
            Role role = getAnswer().getValue();;
            for (Option<Role> op : getOptions()) {
                AppCompatRadioButton radioButton = new AppCompatRadioButton(context);
                radioButton.setId(acc);
                radioButton.setText(op.getDescription());
                if (role != null && op.getData().equals(role)) {
                    radioButton.setChecked(true);
                }
                LinearLayout.LayoutParams layoutParams =
                        new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                                , ViewGroup.LayoutParams.WRAP_CONTENT);
                radioButton.setLayoutParams(layoutParams);
                radioGroup.addView(radioButton, acc++);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        userInteract = true;
                        getAnswer().setValue(getOptions().get(checkedId).getData());
                        if (getObserverQuestion() != null)
                            getObserverQuestion().notifyObserverQuestion(Question4.this);
                    }
                });
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
        dest.writeString(text);
        dest.writeString(title);
        dest.writeInt(layoutResource);
        dest.writeList(options);
    }

    private void readerParcel(Parcel reader) {
        singleAnswer = (SingleAnswer<Role>) reader.readValue(SingleAnswer.class.getClassLoader());
        text = reader.readString();
        title = reader.readString();
        layoutResource = reader.readInt();
        if (options == null)
            options = new ArrayList<>();
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

    @Override
    public boolean isCorrect() {
        return userInteract;
    }
}
