package lib.view.stepform.views.viewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import lib.view.stepform.action.old.LockScrollingViewPager;

public class ViewPagerDisableMovement extends ViewPager {

    private boolean enabled = false;

    private LockScrollingViewPager onTouchEventViewPager;

    public ViewPagerDisableMovement(@NonNull Context context) {
        super(context);
    }

    public ViewPagerDisableMovement(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return this.enabled && super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.enabled && super.onInterceptTouchEvent(ev);
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
