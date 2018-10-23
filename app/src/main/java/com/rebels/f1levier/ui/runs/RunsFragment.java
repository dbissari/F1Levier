package com.rebels.f1levier.ui.runs;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rebels.f1levier.R;

import at.markushi.ui.CircleButton;

public class RunsFragment extends Fragment {

    private FragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RunsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mListener = new RunsListener(getActivity());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_runs, container, false);

        // Set the new run circle button listener
        CircleButton circleButtonNewRun = view.findViewById(R.id.button_new_run);
        circleButtonNewRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 mListener.onButtonNewRunClicked();
            }
        });

        return view;
    }

    public interface FragmentInteractionListener {
        void onButtonNewRunClicked();
    }

}
