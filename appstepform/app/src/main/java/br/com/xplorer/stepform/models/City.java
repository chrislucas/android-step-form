package br.com.xplorer.stepform.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Locale;

public class City implements Parcelable {

    private int id;
    private String name;

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    private City(Parcel parcel) {
        readerToParcel(parcel);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }

    private void readerToParcel(Parcel reader) {
        id = reader.readInt();
        name = reader.readString();
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel source) {
            return new City(source);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "ID %d. Name: %s", id, name);
    }

    @Override
    public boolean equals(Object obj) {
        City that = (City) obj;
        return id == that.getId() && name.equals(that.getName());
    }
}
