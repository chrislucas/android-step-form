package br.com.xplorer.stepform.question.manager;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.xplorer.stepform.R;
import br.com.xplorer.stepform.models.Role;
import lib.view.stepform.models.MultipleAnswer;
import lib.view.stepform.models.QuestionWithMultipleAnswer;
import lib.view.stepform.models.options.Option;

public class Question5 extends QuestionWithMultipleAnswer<Role> {

    private Question5(Parcel reader) {
        readerParcel(reader);
    }

    public Question5(String title, String text, int layoutResource, List<Option<Role>> options) {
        super(title, text, layoutResource, options);
    }

    @Override
    public void bindLayoutWithQuestion(Context context) {
        View viewRoot = getViewRoot();
        if (viewRoot != null) {
            ((TextView) viewRoot.findViewById(R.id.title_question_5))
                    .setText(getText());
            LinearLayout linearLayout = viewRoot.findViewById(R.id.wrapper_group_checkbox);
            int acc = 0;
            final List<Option<Role>> options = getOptions();
            for (Option<Role> op : options) {
                AppCompatCheckBox checkBox = new AppCompatCheckBox(context);
                checkBox.setId(acc);
                checkBox.setText(op.getDescription());
                checkBox.setChecked(getAnswer().thisOptionSelected(op));
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        int id = buttonView.getId();
                        Option<Role> option = options.get(id);
                        if (isChecked) {
                            getAnswer().getValuesSelected().add(option);
                        }
                        else {
                            getAnswer().getValuesSelected().remove(option);
                        }
                    }
                });
                LinearLayout.LayoutParams layoutParams =
                        new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                                , ViewGroup.LayoutParams.WRAP_CONTENT);
                checkBox.setLayoutParams(layoutParams);
                linearLayout.addView(checkBox, acc++);
            }
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(options);
        dest.writeValue(multipleAnswer);
        dest.writeString(text);
        dest.writeString(title);
        dest.writeInt(layoutResource);
    }

    private void readerParcel(Parcel reader) {
        if (options == null)
            options = new ArrayList<>();
        reader.readList(options, Option.class.getClassLoader());
        multipleAnswer = (MultipleAnswer<Role>) reader.readValue(MultipleAnswer.class.getClassLoader());
        text = reader.readString();
        title = reader.readString();
        layoutResource = reader.readInt();
    }

    public static final Creator<Question5> CREATOR = new Parcelable.Creator<Question5>()  {
        @Override
        public Question5 createFromParcel(Parcel source) {
            return new Question5(source);
        }

        @Override
        public Question5 [] newArray(int size) {
            return new Question5[size];
        }
    };

    @Override
    public boolean validate() {
        return false;
    }
}
