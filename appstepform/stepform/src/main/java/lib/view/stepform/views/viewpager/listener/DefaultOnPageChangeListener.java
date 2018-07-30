package lib.view.stepform.views.viewpager.listener;

import android.support.v4.view.ViewPager;
import android.view.View;

import lib.view.stepform.action.QuestionCallback;
import lib.view.stepform.views.viewpager.callback.CallbackPageChangeListener;

public class DefaultOnPageChangeListener implements ViewPager.OnPageChangeListener {

    private QuestionCallback callback;

    public interface CallbackOnPageChangeListener {
        void onPageSelected(int position);
    }

    private CallbackOnPageChangeListener callbackOnPageChangeListener;

    public DefaultOnPageChangeListener(QuestionCallback callback, CallbackOnPageChangeListener callbackOnPageChangeListener) {
        this.callback = callback;
        this.callbackOnPageChangeListener = callbackOnPageChangeListener;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        this.callback.whenSelecting(position);
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
