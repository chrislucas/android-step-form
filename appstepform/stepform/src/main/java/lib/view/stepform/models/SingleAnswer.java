package lib.view.stepform.models;

import android.os.Parcel;
import android.os.Parcelable;

import lib.view.stepform.models.action.ValidationAnswer;


/**
 * Essa classe representa uma resposta de uma pergunta no questionario.
 *
 * Ela representa a resposta de uma pergunta que so admite uma unica resposta?
 * 1 tipo primitivo, 1 instancia de uma classe (seja ela do Java ou criada por um desenvolvedor)
 *
 * */

public class SingleAnswer<T> extends Answer<T> implements Parcelable {

    private T data;

    public SingleAnswer(ValidationAnswer<T> validation) {
        super(validation);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    protected boolean validate() {
        return validation.validate(this);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel writer, int flags) {

    }

    private void readerParcel(Parcel reader) {

    }

    private SingleAnswer(Parcel parcel) {
        readerParcel(parcel);
    }


    public static final Parcelable.Creator<SingleAnswer> CREATOR = new Parcelable.Creator<SingleAnswer>() {
        @Override
        public SingleAnswer createFromParcel(Parcel source) {
            return new SingleAnswer(source);
        }

        @Override
        public SingleAnswer[] newArray(int size) {
            return new SingleAnswer[size];
        }
    };
}
