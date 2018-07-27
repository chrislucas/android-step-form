package lib.view.stepform.views.viewpager.callback;

public interface CallbackPageChangeListener {
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels);
    public void onPageSelected(int position);
    public void onPageScrollStateChanged(int state);
}
