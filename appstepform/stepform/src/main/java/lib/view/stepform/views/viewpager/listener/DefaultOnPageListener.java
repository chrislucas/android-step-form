package lib.view.stepform.views.viewpager.listener;

import android.support.v4.view.ViewPager;

import lib.view.stepform.views.viewpager.callback.CallbackPageChange;

public class DefaultOnPageListener implements ViewPager.OnPageChangeListener {

    private CallbackPageChange callbackPageChange;

    public DefaultOnPageListener(CallbackPageChange callbackPageChange) {
        this.callbackPageChange = callbackPageChange;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        callbackPageChange.onPageScrolled(position, positionOffset, positionOffsetPixels);
    }

    @Override
    public void onPageSelected(int position) {
        callbackPageChange.onPageSelected(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        callbackPageChange.onPageScrollStateChanged(state);
    }
}
