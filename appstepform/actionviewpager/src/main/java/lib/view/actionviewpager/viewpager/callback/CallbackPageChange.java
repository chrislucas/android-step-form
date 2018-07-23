package lib.view.actionviewpager.viewpager.callback;

public interface CallbackPageChange<T> {
    public void onPageScrolled(T data, int position, float positionOffset, int positionOffsetPixels);
    public void onPageSelected(T data, int position);
    public void onPageScrollStateChanged(int state);
}
