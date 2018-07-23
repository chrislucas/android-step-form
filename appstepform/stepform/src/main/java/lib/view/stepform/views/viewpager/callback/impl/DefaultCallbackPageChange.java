package lib.view.stepform.views.viewpager.callback.impl;

import lib.view.stepform.action.QuestionCallback;
import lib.view.stepform.views.viewpager.callback.CallbackPageChange;

public class DefaultCallbackPageChange implements CallbackPageChange {

    private QuestionCallback callback;

    public DefaultCallbackPageChange(QuestionCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        this.callback.whenPassing(position);
    }

    @Override
    public void onPageSelected(int position) {
        this.callback.whenSelecting(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
