package com.rebels.f1levier.ui.participant;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rebels.f1levier.R;
import com.rebels.f1levier.db.entity.ParticipantEntity;
import com.rebels.f1levier.viewmodel.ParticipantViewModel;

import java.util.List;
import java.util.Objects;

public class ParticipantFragment extends Fragment {

    public ParticipantFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_participant_list, container, false);

        Context context = view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.participant_list);
        final ParticipantListAdapter adapter = new ParticipantListAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        ParticipantViewModel participantViewModel = ViewModelProviders.of(this).get(ParticipantViewModel.class);
        participantViewModel.getAllParticipants().observe(this,
                new Observer<List<ParticipantEntity>>() {
            @Override
            public void onChanged(@Nullable final List<ParticipantEntity> participants) {
                adapter.setParticipants(participants);
            }
        });

        DividerItemDecoration itemDecoration = new DividerItemDecoration(context,
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        FloatingActionButton addFab = view.findViewById(R.id.fab_add);
        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewParticipantDialog newParticipantDialog = new NewParticipantDialog();
                newParticipantDialog.show(Objects.requireNonNull(getFragmentManager()), null);
            }
        });

        return view;
    }
}
