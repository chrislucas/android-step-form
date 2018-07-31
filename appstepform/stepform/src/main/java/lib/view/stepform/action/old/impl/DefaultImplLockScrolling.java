package lib.view.stepform.action.old.impl;

import android.view.MotionEvent;
import android.view.View;

import lib.view.stepform.action.old.LockScrollingViewPager;

public class DefaultImplLockScrolling implements LockScrollingViewPager {

    private boolean enabled;
    private View view;

    public DefaultImplLockScrolling(View view, boolean enabled) {
        this.view = view;
        this.enabled = enabled;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return enabled;
    }


    @Override
    public void toggleEnable(boolean flag) {
        this.enabled = flag;
    }
}
