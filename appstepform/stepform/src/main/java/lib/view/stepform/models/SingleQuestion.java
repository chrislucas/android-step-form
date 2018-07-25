package lib.view.stepform.models;


import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;

import java.util.List;

import lib.view.stepform.action.ManagerLayoutQuestion;
import lib.view.stepform.action.ValidationAnswer;
import lib.view.stepform.models.options.Option;

public class SingleQuestion<T> extends Question<T> {

    private SingleAnswer<T> singleAnswer;

    private SingleQuestion() {}

    private SingleQuestion(Parcel reader) {
        readerParcel(reader);
    }

    public SingleQuestion(ManagerLayoutQuestion managerLayoutQuestion
            , ValidationAnswer<T> validationAnswer,  String questionText, @LayoutRes int layoutRes) {
        super(managerLayoutQuestion, validationAnswer, questionText, layoutRes);
    }

    public SingleQuestion(ManagerLayoutQuestion managerLayoutQuestion
            , ValidationAnswer<T> validationAnswer, String questionText, @LayoutRes int layoutRes, List<Option<T>> options) {
        super(managerLayoutQuestion, validationAnswer, questionText, layoutRes, options);
    }

    @Override
    public Answer<T> getAnswer() {
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
        dest.writeValue(singleAnswer);
        dest.writeString(questionText);
        dest.writeInt(layoutResource);
    }

    private void readerParcel(Parcel reader) {
        singleAnswer = (SingleAnswer<T>) reader.readValue(SingleAnswer.class.getClassLoader());
        questionText = reader.readString();
        layoutResource = reader.readInt();
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

    @Override
    protected boolean validate() {
        return validation != null && validation.validate(answer);
    }
}
