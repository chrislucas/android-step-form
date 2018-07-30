package lib.view.stepform.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;


/**
 * Essa classe representa uma resposta de uma pergunta no questionario.
 *
 * Ela representa a resposta de uma pergunta que so admite uma unica resposta?
 * 1 tipo primitivo, 1 instancia de uma classe (seja ela do Java ou criada por um desenvolvedor)
 *
 * */

public class SingleAnswer<T> extends Answer<T> implements Parcelable {

    private T value;

    private static ClassLoader mClassLoader;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
        SingleAnswer.mClassLoader = value.getClass().getClassLoader();
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
        if (mClassLoader != null) {
            try {
                value = (T) reader.readValue(mClassLoader);
            } catch (Exception e) {
                Log.e("CLS_CAST_EXCEPT_OPT_CLS", e.getMessage());
            }
        }
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

    @Override
    public String toString() {
        return String.format("Resposta %s", value.toString());
    }
}
