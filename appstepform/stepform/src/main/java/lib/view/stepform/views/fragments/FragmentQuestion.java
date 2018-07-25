package lib.view.stepform.views.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import lib.view.stepform.R;
import lib.view.stepform.models.Question;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentQuestion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentQuestion extends Fragment {

    private Question question;

    public FragmentQuestion() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentQuestion newInstance(Question question) {
        FragmentQuestion fragment = new FragmentQuestion();
        fragment.question = question;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot = inflater.inflate(R.layout.fragment_question, container, false);
        LinearLayout linearLayout = viewRoot.findViewById(R.id.wrapper_layout_question);
        linearLayout.addView(question.getView(getContext()));
        return viewRoot;
    }

}
