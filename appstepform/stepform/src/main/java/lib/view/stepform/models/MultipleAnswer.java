package lib.view.stepform.models;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import lib.view.stepform.models.action.ValidationAnswer;
import lib.view.stepform.models.options.Option;


public class MultipleAnswer<T> extends Answer<T> implements Parcelable {

    private List<Option<T>> data;

    public MultipleAnswer(ValidationAnswer<T> validation) {
        super(validation);
    }

    public List<Option<T>> getData() {
        return data;
    }

    public void setData(List<Option<T>> data) {
        this.data = data;
    }

    @Override
    protected boolean validate() {
        return validation.validate(this);
    }

    public MultipleAnswer() {}

    private MultipleAnswer(Parcel parcel) {
        readerParcel(parcel);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    private void readerParcel(Parcel reader) {

    }


    public static Parcelable.Creator<MultipleAnswer> CREATOR = new Parcelable.Creator<MultipleAnswer>() {
        @Override
        public MultipleAnswer createFromParcel(Parcel source) {
            return new MultipleAnswer(source);
        }

        @Override
        public MultipleAnswer[] newArray(int size) {
            return new MultipleAnswer[size];
        }
    };
}
