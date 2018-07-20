package lib.view.stepform.views.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lib.view.stepform.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentQuestion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentQuestion extends Fragment {


    public FragmentQuestion() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentQuestion newInstance() {
        FragmentQuestion fragment = new FragmentQuestion();
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
        return inflater.inflate(R.layout.fragment_question, container, false);
    }

}
