package br.com.xplorer.stepform.question.manager;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

import java.util.List;

import lib.view.stepform.models.MultipleAnswer;
import lib.view.stepform.models.MultipleQuestion;
import lib.view.stepform.models.options.Option;

public class Question5<T> extends MultipleQuestion<T> {

    private Context context;

    private Question5(Parcel reader) {
        readerParcel(reader);
    }

    public Question5(String title, String text, int layoutResource, List<Option<T>> options, Context context) {
        super(title, text, layoutResource, options);
        this.context = context;
    }

    @Override
    public void bindLayoutWithQuestion(Context context) {
        View viewRoot = getViewRoot();
        if (viewRoot != null) {

        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(options);
        dest.writeValue(multipleAnswer);
        dest.writeString(text);
        dest.writeInt(layoutResource);
    }

    private void readerParcel(Parcel reader) {
        reader.readList(options, Option.class.getClassLoader());
        multipleAnswer = (MultipleAnswer<T>) reader.readValue(MultipleAnswer.class.getClassLoader());
        text = reader.readString();
        layoutResource = reader.readInt();
    }

    public static final Creator<Question5<?>> CREATOR = new Parcelable.Creator<Question5<?>>()  {
        @Override
        public Question5<?> createFromParcel(Parcel source) {
            return new Question5(source);
        }

        @Override
        public Question5<?>[] newArray(int size) {
            return new Question5[size];
        }
    };

    @Override
    public boolean validate() {
        return false;
    }
}
