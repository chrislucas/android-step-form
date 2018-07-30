package lib.view.stepform.models;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import lib.view.stepform.models.options.Option;


public class MultipleAnswer<T> extends Answer<T> implements Parcelable {

    private LinkedHashSet<Option<T>> valuesSelected;

    public MultipleAnswer() {
        valuesSelected = new LinkedHashSet<>();
    }

    public LinkedHashSet<Option<T>> getValuesSelected() {
        return valuesSelected;
    }

    public boolean thisOptionSelected(Option<T> p) {
        if (valuesSelected != null && valuesSelected.size() > 0) {
            return valuesSelected.contains(p);
        }
        return false;
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
        if (valuesSelected == null)
            valuesSelected = new LinkedHashSet<>();
        Object [] objects = this.valuesSelected.toArray();
        Option[] selectedOptionsArray = new Option[objects.length];
        System.arraycopy(objects, 0, selectedOptionsArray, 0, objects.length);
        writer.writeArray(selectedOptionsArray);
    }

    private void readerParcel(Parcel reader) {
        if (valuesSelected == null)
            valuesSelected = new LinkedHashSet<>();
        Object [] selectedOptionsArray = reader.readArray(Option.class.getClassLoader());
        if (selectedOptionsArray.length >  0) {
            for (Object object : selectedOptionsArray) {
                valuesSelected.add((Option<T>) object);
            }
        }
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
