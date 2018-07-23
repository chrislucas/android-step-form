package lib.view.stepform.views.viewpager.listener;

import android.support.v4.view.ViewPager;

/**
 * {@link android.support.v4.view.ViewPager.SimpleOnPageChangeListener} eh
 * uma implementacao vazia da interface {@link android.support.v4.view.ViewPager.OnPageChangeListener}
 * */
public class DefaultSimpleOnPageListener extends ViewPager.SimpleOnPageChangeListener {

    public DefaultSimpleOnPageListener() {
        super();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
    }

    @Override
    public void onPageSelected(int position) {
        super.onPageSelected(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        super.onPageScrollStateChanged(state);
    }
}
