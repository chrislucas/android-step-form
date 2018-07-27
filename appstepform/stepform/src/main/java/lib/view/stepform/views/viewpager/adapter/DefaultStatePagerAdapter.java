package lib.view.stepform.views.viewpager.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import lib.view.stepform.models.Question;
import lib.view.stepform.views.fragments.FragmentQuestion;

public class DefaultStatePagerAdapter extends FragmentStatePagerAdapter {

    private List<Question> questions;
    private FragmentManager fm;
    private Fragment [] fragments;

    public DefaultStatePagerAdapter(FragmentManager fm, List<Question> questions) {
        super(fm);
        this.questions = questions;
        this.fm = fm;
        fragments = new Fragment[questions.size()];
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fg = fragments[position];
        if (fg == null) {
            fg =  FragmentQuestion.newInstance(questions.get(position));
            fragments[position] = fg;
        }
        return fg;
    }

    @Override
    public int getCount() {
        return questions.size();
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return questions.get(position).getTitle();
    }

    /**
     * Quando a activity que comporta a ViewPager rotaciona o metodo
     * */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object ref = super.instantiateItem(container, position);
        fragments[position] = (Fragment) ref;
        return ref;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return super.isViewFromObject(view, object);
    }
}
