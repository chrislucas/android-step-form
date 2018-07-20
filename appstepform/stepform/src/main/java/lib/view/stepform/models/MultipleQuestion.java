package lib.view.stepform.models;


import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;

import java.util.List;

import lib.view.stepform.models.options.Option;

public class MultipleQuestion<T> extends Question<T> {

    private MultipleAnswer<T> multipleAnswer;
    private List<Option<T>> options;

    public MultipleQuestion() {
        super("", 0);
    }

    private MultipleQuestion(Parcel reader) {
        this();
        readerParcel(reader);
    }

    public MultipleQuestion(String questionText, @LayoutRes int layoutResource, List<Option<T>> options) {
        super(questionText, layoutResource);
        this.options = options;
    }

    @Override
    public Answer<T> getAnswer() {
        return multipleAnswer;
    }

    @Override
    public void setAnswer(Answer<T> answer) {
        this.multipleAnswer = (MultipleAnswer<T>) answer;
    }

    public List<Option<T>> getOptions() {
        return options;
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

    public static final Parcelable.Creator<MultipleQuestion> CREATOR =
            new Parcelable.Creator<MultipleQuestion>()  {
        @Override
        public MultipleQuestion createFromParcel(Parcel source) {
            return new MultipleQuestion(source);
        }

        @Override
        public MultipleQuestion[] newArray(int size) {
            return new MultipleQuestion[size];
        }
    };
}
