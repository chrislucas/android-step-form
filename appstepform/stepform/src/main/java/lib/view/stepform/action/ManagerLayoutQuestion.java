package lib.view.stepform.action;


import android.content.Context;
import android.os.Parcelable;

public interface ManagerLayoutQuestion<T> extends Parcelable {
    void bindLayoutWithQuestion(Context context);
}
