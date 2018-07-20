package lib.view.stepform.models.options;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Classe que representa uma opcao numa determinada questao com muitas opcoes.
 * */
public class Option<T> implements Parcelable {

    private T data;
    private String description;

    public Option(T data, String description) {
        this.data = data;
        this.description = description;
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
    public void writeToParcel(Parcel dest, int flags) {

    }


    private void readerParcel(Parcel reader) {

    }


    public static final Parcelable.Creator<Option> CREATOR = new Parcelable.Creator<Option>() {
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
