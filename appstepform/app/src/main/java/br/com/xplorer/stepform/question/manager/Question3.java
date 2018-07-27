package br.com.xplorer.stepform.question.manager;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.xplorer.stepform.R;
import br.com.xplorer.stepform.adapters.spinner.AdapterSpinnerOptions;
import br.com.xplorer.stepform.models.City;
import lib.view.stepform.models.SingleAnswer;
import lib.view.stepform.models.QuestionWithSingleAnswer;
import lib.view.stepform.models.options.Option;

public class Question3<T> extends QuestionWithSingleAnswer<T> {

    private Question3(Parcel reader) {
        readerParcel(reader);
    }

    public Question3(String title, String text, int layoutRes) {
        super(title, text, layoutRes);
    }

    public Question3(String title, String text, int layoutRes, List<Option<T>> list) {
        super(title, text, layoutRes, list);
    }

    @Override
    public void bindLayoutWithQuestion(final Context context) {
        View viewRoot = getViewRoot();
        if (viewRoot != null) {
            ((TextView) viewRoot.findViewById(R.id.title_question_3))
                    .setText(getText());
            Spinner citiesOptions = viewRoot.findViewById(R.id.cities_options);
            final List<Option<T>> options = getOptions();
            if (options != null) {
                AdapterSpinnerOptions<T> adapter =
                        new AdapterSpinnerOptions<>(
                                context
                                , R.layout.custom_text_item_spinner      // layout do spinner fechado
                                , options
                                , R.layout.custom_layout_dropdown_item    // layout do spinner aberto
                        );

                citiesOptions.setAdapter(adapter);
                citiesOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Option<T> option = options.get(position);
                        City city = (City) option.getData();
                        Toast.makeText(context
                                , city.getName(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {}
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
        singleAnswer = (SingleAnswer<T>) reader.readValue(SingleAnswer.class.getClassLoader());
        text = reader.readString();
        title = reader.readString();
        layoutResource = reader.readInt();
        if (options == null)
            options = new ArrayList<>();
        reader.readList(options, Option.class.getClassLoader());
    }

    public static final Creator<Question3<?>> CREATOR = new Parcelable.Creator<Question3<?>>() {
        @Override
        public Question3<?> createFromParcel(Parcel source) {
            return new Question3(source);
        }

        @Override
        public Question3<?>[] newArray(int size) {
            return new Question3[size];
        }
    };

    @Override
    public boolean validate() {
        return false;
    }
}
