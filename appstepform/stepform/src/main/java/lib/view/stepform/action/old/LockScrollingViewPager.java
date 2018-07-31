package lib.view.stepform.action.old;

import android.view.MotionEvent;

public interface LockScrollingViewPager {
    boolean onTouchEvent(MotionEvent ev);
    void toggleEnable(boolean flag);
}
