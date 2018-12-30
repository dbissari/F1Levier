package com.rebels.f1levier.ui.race;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rebels.f1levier.R;
import com.rebels.f1levier.db.entity.Race;
import com.rebels.f1levier.ui.team.TeamActivity;
import com.rebels.f1levier.viewmodel.RaceViewModel;

import java.util.List;
import java.util.Objects;

import at.markushi.ui.CircleButton;

public class RaceFragment extends Fragment implements RaceListAdapter.InteractionListener {

    private static final String NEW_RACE_DIALOG_CODE = "new_race";

    private RaceViewModel raceViewModel;

    public RaceFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        raceViewModel = ViewModelProviders.of(this).get(RaceViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_race_list, container, false);

        Context context = view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.race_list);
        final RaceListAdapter adapter = new RaceListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        raceViewModel.getNotStartedRaces().observe(this,
                new Observer<List<Race>>() {
                    @Override
                    public void onChanged(@Nullable final List<Race> races) {
                        adapter.setRaces(races);
                    }
                });

        DividerItemDecoration itemDecoration = new DividerItemDecoration(context,
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        // Set the new race circle button listener
        CircleButton circleButtonNewRace = view.findViewById(R.id.button_new_race);
        circleButtonNewRace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewRaceDialog newRaceDialog = new NewRaceDialog();
                newRaceDialog.show(Objects.requireNonNull(getFragmentManager()),
                        NEW_RACE_DIALOG_CODE);
            }
        });

        return view;
    }

    @Override
    public void onRaceItemClicked(Race race) {
        Context context = Objects.requireNonNull(getContext());
        Intent teamIntent = new Intent(context, TeamActivity.class);
        teamIntent.putExtra("race_id", race.id);
        context.startActivity(teamIntent);
    }
}
