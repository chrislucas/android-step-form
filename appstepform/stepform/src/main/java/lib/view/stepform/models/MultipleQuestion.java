package lib.view.stepform.models;


import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;

import java.util.ArrayList;
import java.util.List;

import lib.view.stepform.action.ManagerLayoutQuestion;
import lib.view.stepform.action.ValidationAnswer;
import lib.view.stepform.models.options.Option;

public class MultipleQuestion<T> extends Question<T> {

    private MultipleAnswer<T> multipleAnswer;

    public MultipleQuestion(ManagerLayoutQuestion managerLayoutQuestion, ValidationAnswer<T> validationAnswer, String questionText
            , @LayoutRes int layoutResource, List<Option<T>> options) {
        super(managerLayoutQuestion, validationAnswer, questionText, layoutResource, options);
    }

    private MultipleQuestion() {
        options = new ArrayList<>();
    }

    private MultipleQuestion(Parcel reader) {
        this();
        readerParcel(reader);
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
        dest.writeList(options);
        dest.writeValue(multipleAnswer);
        dest.writeString(questionText);
        dest.writeInt(layoutResource);
    }

    private void readerParcel(Parcel reader) {
        reader.readList(options, Option.class.getClassLoader());
        multipleAnswer = (MultipleAnswer<T>) reader.readValue(MultipleAnswer.class.getClassLoader());
        questionText = reader.readString();
        layoutResource = reader.readInt();
    }

    public static final Creator<MultipleQuestion<?>> CREATOR =
            new Parcelable.Creator<MultipleQuestion<?>>()  {
        @Override
        public MultipleQuestion<?> createFromParcel(Parcel source) {
            return new MultipleQuestion(source);
        }

        @Override
        public MultipleQuestion<?>[] newArray(int size) {
            return new MultipleQuestion[size];
        }
    };

    @Override
    protected boolean validate() {
        return validation != null && validation.validate(answer);
    }
}
