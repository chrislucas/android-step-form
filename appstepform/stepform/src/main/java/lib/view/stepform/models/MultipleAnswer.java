package lib.view.stepform.models;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import lib.view.stepform.models.options.Option;


public class MultipleAnswer<T> extends Answer<T> implements Parcelable {

    private List<Option<T>> optionsToChoose;

    private T selectedOption;

    public MultipleAnswer() {
        optionsToChoose = new ArrayList<>();
    }

    public List<Option<T>> getOptionsToChoose() {
        return optionsToChoose;
    }

    public void setOptionsToChoose(List<Option<T>> optionsToChoose) {
        this.optionsToChoose = optionsToChoose;
    }

    public T getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(T selectedOption) {
        this.selectedOption = selectedOption;
    }

    private MultipleAnswer(Parcel parcel) {
        readerParcel(parcel);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel writer, int flags) {
        writer.writeList(optionsToChoose);
        writer.writeValue(selectedOption);
    }

    private void readerParcel(Parcel reader) {
        reader.readList(optionsToChoose, Option.class.getClassLoader());
        selectedOption = (T) reader.readValue(Object.class.getClassLoader());
    }


    public static Creator<MultipleAnswer<?>> CREATOR = new Creator<MultipleAnswer<?>>() {

        @Override
        public MultipleAnswer createFromParcel(Parcel source) {
            return new MultipleAnswer<>(source);
        }

        @Override
        public MultipleAnswer[] newArray(int size) {
            return new MultipleAnswer[size];
        }
    };
}
