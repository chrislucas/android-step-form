package lib.view.stepform.views.viewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class DisableViewPager extends ViewPager {

    private boolean enabled = false;

    public DisableViewPager(@NonNull Context context) {
        super(context);
    }

    public DisableViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        if ( ! enabled && ev.getActionMasked() == MotionEvent.ACTION_MOVE)
            return false;
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
