package lib.view.actionviewpager.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import lib.view.actionviewpager.R;


public class FragmentViewPager<T> extends Fragment {


    private List<T> list;

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private PagerTitleStrip mPagerTitleStrip;
    private ViewPager.PageTransformer mPageTransformer;
    private ViewPager.OnPageChangeListener mPageChangeListener;

    public FragmentViewPager() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static <T> FragmentViewPager newInstance(List<T> list) {
        FragmentViewPager fragment = new FragmentViewPager();
        fragment.list = list;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);
        return view;
    }


    public List<T> getList() {
        return list;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
