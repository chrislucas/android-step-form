package lib.view.stepform.models;


import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;

public class SingleQuestion<T> extends Question<T> {

    private SingleAnswer<T> singleAnswer;

    private SingleQuestion() {
        super("", 0);
    }

    private SingleQuestion(Parcel reader) {
        this();
        readerParcel(reader);
    }

    public SingleQuestion(String questionText, @LayoutRes int layoutRes) {
        super(questionText, layoutRes);
    }

    @Override
    public Answer getAnswer() {
        return singleAnswer;
    }

    @Override
    public void setAnswer(Answer answer) {
        this.singleAnswer = (SingleAnswer<T>) answer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    private void readerParcel(Parcel parcel) {

    }

    public static final Parcelable.Creator<SingleQuestion> CREATOR = new Parcelable.Creator<SingleQuestion>() {
        @Override
        public SingleQuestion createFromParcel(Parcel source) {
            return new SingleQuestion(source);
        }

        @Override
        public SingleQuestion[] newArray(int size) {
            return new SingleQuestion[size];
        }
    };
}
