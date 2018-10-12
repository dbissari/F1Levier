package com.rebels.f1levier.ui.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rebels.f1levier.R;
import com.rebels.f1levier.model.Level;
import com.rebels.f1levier.model.Participant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParticipantsFragment extends Fragment {

    private View view;
    private RecyclerView mRecyclerView;
    private ParticipantsAdapter participantsAdapter;
    private List<Participant> participants = new ArrayList<>();

    public ParticipantsFragment() {
        participants.add(new Participant("Serge", new Level("Débutant", 1)));
        participants.add(new Participant("Déromba", new Level("Intermédiaire", 2)));
        participants.add(new Participant("Bissari", new Level("Avancé", 3)));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_participants, container, false);

        participantsAdapter = new ParticipantsAdapter(participants);
        mRecyclerView = view.findViewById(R.id.recycler_view_participants);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(participantsAdapter);

        return view;
    }

}
