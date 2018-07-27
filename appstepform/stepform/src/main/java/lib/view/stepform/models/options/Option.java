package lib.view.stepform.models.options;


import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Classe que representa uma opcao numa determinada questao com muitas opcoes.
 * */
public class Option<T> implements Parcelable {

    private T data;
    private String description;

    private static ClassLoader mClassLoader;

    public Option(T data, String description) {
        this.data = data;
        this.description = description;
        Option.mClassLoader = data.getClass().getClassLoader();
    }

    public T getData() {
        return data;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("Description: %s.\n Data: %s"
                , description
                , data.toString()
        );
    }

    private Option(Parcel reader) {
        readerParcel(reader);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel writer, int flags) {
        writer.writeValue(data);
        writer.writeString(description);
    }

    private void readerParcel(Parcel reader) {
        try {
            this.data = (T) reader.readValue(Option.mClassLoader);
        }
        catch (Exception e) {
            Log.e("CLS_CAST_EXCEPT_OPT_CLS", e.getMessage());
        }
        this.description = reader.readString();
    }

    public static final Creator<Option<?>> CREATOR = new Creator<Option<?>>() {
        @Override
        public Option createFromParcel(Parcel source) {
            return new Option(source);
        }

        @Override
        public Option[] newArray(int size) {
            return new Option[size];
        }
    };
}
