package br.com.xplorer.stepform.question.manager;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.xplorer.stepform.R;
import br.com.xplorer.stepform.adapters.spinner.AdapterSpinnerOptions;
import br.com.xplorer.stepform.models.City;
import lib.view.stepform.action.ManagerLayoutQuestion;
import lib.view.stepform.models.Question;
import lib.view.stepform.models.SingleQuestion;
import lib.view.stepform.models.options.Option;

public class ManagerQuestion3 implements ManagerLayoutQuestion {

    private Context context;
    private Question question;

    public ManagerQuestion3(Context context) {
        this.context = context;
    }

    @Override
    public void bindLayoutWithQuestion(Question question) {
        SingleQuestion<City> singleQuestion = (SingleQuestion<City>) question;
        View viewRoot = question.getView(context);
        if (viewRoot != null) {

            ((TextView) viewRoot.findViewById(R.id.title_question_3))
                    .setText(question.getQuestionText());

            Spinner citiesOptions = viewRoot.findViewById(R.id.cities_options);

            final List<Option<City>> options = singleQuestion.getOptions();
            AdapterSpinnerOptions<City> adapter =
                    new AdapterSpinnerOptions<>(context
                            , R.layout.custom_text_item_spinner       // layout do spinner fechado
                            , options
                            , R.layout.custom_layout_dropdown_item    // layout do spinner aberto
                    );

            citiesOptions.setAdapter(adapter);

            citiesOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Option<City> option = options.get(position);
                    City city = option.getData();
                    Toast.makeText(context
                            , city.getName(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            });
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

    private ManagerQuestion3(Parcel reader) {
        readerToParcel(reader);
    }


    public static final Parcelable.Creator<ManagerQuestion3> CREATOR = new Parcelable.Creator<ManagerQuestion3>() {
        @Override
        public ManagerQuestion3 createFromParcel(Parcel source) {
            return new ManagerQuestion3(source);
        }

        @Override
        public ManagerQuestion3[] newArray(int size) {
            return new ManagerQuestion3[size];
        }
    };
}
