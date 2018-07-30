package br.com.xplorer.stepform.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Locale;

public class Role implements Parcelable{

    private int id;
    private String description;

    public Role(int id, String description) {
        this.id = id;
        this.description = description;
    }

    private Role(Parcel reader) {
        readerToParcel(reader);
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel writer, int flags) {
        writer.writeInt(id);
        writer.writeString(description);
    }

    private void readerToParcel(Parcel reader) {
        id = reader.readInt();
        description = reader.readString();
    }

    public static final Creator<Role> CREATOR = new Creator<Role>() {
        @Override
        public Role createFromParcel(Parcel source) {
            return new Role(source);
        }

        @Override
        public Role[] newArray(int size) {
            return new Role[size];
        }
    };

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "ID: %d Desc: %s", id, description);
    }

    @Override
    public boolean equals(Object obj) {
        Role that = (Role) obj;
        return id == that.getId() && description == that.getDescription();
    }
}
