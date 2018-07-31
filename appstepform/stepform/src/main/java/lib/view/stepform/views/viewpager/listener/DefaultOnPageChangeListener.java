package lib.view.stepform.views.viewpager.listener;

import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import lib.view.stepform.action.QuestionCallback;
import lib.view.stepform.views.viewpager.callback.CallbackOnPageChangeListener;

public class DefaultOnPageChangeListener implements ViewPager.OnPageChangeListener {



    private CallbackOnPageChangeListener callbackOnPageChangeListener;

    public DefaultOnPageChangeListener(@Nullable CallbackOnPageChangeListener callbackOnPageChangeListener) {

        this.callbackOnPageChangeListener = callbackOnPageChangeListener;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (callbackOnPageChangeListener != null)
            callbackOnPageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
    }

    @Override
    public void onPageSelected(int position) {
        if (callbackOnPageChangeListener != null)
            this.callbackOnPageChangeListener.onPageSelected(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        /**
         * Called when the scroll state changes. Useful for discovering when the user
         * begins dragging, when the pager is automatically settling to the current page,
         * or when it is fully stopped/idle.
         *
         * @param state The new scroll state.
         * @see ViewPager#SCROLL_STATE_IDLE
         * @see ViewPager#SCROLL_STATE_DRAGGING
         * @see ViewPager#SCROLL_STATE_SETTLING
         */
        switch (state) {
            case ViewPager.SCROLL_STATE_IDLE:
                break;
            case ViewPager.SCROLL_STATE_DRAGGING:
                break;
            case ViewPager.SCROLL_STATE_SETTLING:
                break;
        }
    }
}
