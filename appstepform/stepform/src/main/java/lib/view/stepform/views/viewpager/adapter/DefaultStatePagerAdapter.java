package lib.view.stepform.views.viewpager.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import lib.view.stepform.models.Question;
import lib.view.stepform.views.fragments.FragmentQuestion;

public class DefaultStatePagerAdapter extends FragmentStatePagerAdapter {

    private List<Question> questions;

    public DefaultStatePagerAdapter(FragmentManager fm, List<Question> questions) {
        super(fm);
        this.questions = questions;
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentQuestion.newInstance(questions.get(position));
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
}
