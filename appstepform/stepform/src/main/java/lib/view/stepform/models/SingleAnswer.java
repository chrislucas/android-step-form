package lib.view.stepform.models;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Essa classe representa uma resposta de uma pergunta no questionario.
 *
 * Ela representa a resposta de uma pergunta que so admite uma unica resposta?
 * 1 tipo primitivo, 1 instancia de uma classe (seja ela do Java ou criada por um desenvolvedor)
 *
 * */

public class SingleAnswer<T> extends Answer<T> implements Parcelable {

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public SingleAnswer() {}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel writer, int flags) {
        writer.writeValue(value);
    }

    private void readerParcel(Parcel reader) {
        value = (T) reader.readValue(Object.class.getClassLoader());
    }

    private SingleAnswer(Parcel parcel) {
        readerParcel(parcel);
    }

    public static final Parcelable.Creator<SingleAnswer<?>> CREATOR = new Parcelable.Creator<SingleAnswer<?>>() {
        @Override
        public SingleAnswer<?> createFromParcel(Parcel source) {
            return new SingleAnswer(source);
        }

        @Override
        public SingleAnswer<?>[] newArray(int size) {
            return new SingleAnswer[size];
        }
    };
}
