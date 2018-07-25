package br.com.xplorer.stepform.question.manager;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.xplorer.stepform.R;
import br.com.xplorer.stepform.adapters.spinner.AdapterSpinnerOptions;
import br.com.xplorer.stepform.models.City;
import br.com.xplorer.stepform.models.Role;
import lib.view.stepform.action.ManagerLayoutQuestion;
import lib.view.stepform.models.MultipleQuestion;
import lib.view.stepform.models.Question;

import lib.view.stepform.models.options.Option;

public class ManagerQuestion4 implements ManagerLayoutQuestion {

    private Context context;
    private Question question;

    public ManagerQuestion4(Context context) {
        this.context = context;
    }

    @Override
    public void bindLayoutWithQuestion(Question question) {
        MultipleQuestion<Role> multipleQuestion = (MultipleQuestion<Role>) question;
        View viewRoot = multipleQuestion.getView(context);
        if (viewRoot != null) {
            ((TextView) viewRoot.findViewById(R.id.title_question_4))
                    .setText(multipleQuestion.getQuestionText());
            RadioGroup radioGroup = viewRoot.findViewById(R.id.group_roles);

            int acc = 0;
            for (Option<Role> op : multipleQuestion.getOptions()) {
                AppCompatRadioButton radioButton = new AppCompatRadioButton(context);
                radioButton.setText(op.getDescription());
                LinearLayout.LayoutParams layoutParams =
                        new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                radioGroup.addView(radioButton, acc++, layoutParams);
            }
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

    private ManagerQuestion4(Parcel reader) {
        readerToParcel(reader);
    }

    private void readerToParcel(Parcel reader) {
        question = (Question) reader.readValue(Question.class.getClassLoader());
    }

    public static final Parcelable.Creator<ManagerQuestion4> CREATOR = new Creator<ManagerQuestion4>() {
        @Override
        public ManagerQuestion4 createFromParcel(Parcel source) {
            return new ManagerQuestion4(source);
        }

        @Override
        public ManagerQuestion4[] newArray(int size) {
            return new ManagerQuestion4[size];
        }
    };
}
