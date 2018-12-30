package com.rebels.f1levier.ui.team;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.rebels.f1levier.R;
import com.rebels.f1levier.db.entity.Team;
import com.rebels.f1levier.viewmodel.TeamViewModel;

import java.util.List;
import java.util.Objects;

public class TeamActivity extends AppCompatActivity {

    private static final String NEW_TEAM_DIALOG_CODE = "new_team";

    private int raceId;
    private TeamViewModel teamViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        raceId = getIntent().getIntExtra("race_id", -1);
        if (raceId == -1) {
            finish();
        }

        teamViewModel = ViewModelProviders.of(this).get(TeamViewModel.class);

        RecyclerView recyclerView = findViewById(R.id.team_list);
        final TeamListAdapter adapter = new TeamListAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        teamViewModel.getTeamsByRaceId(raceId).observe(this,
                new Observer<List<Team>>() {
                    @Override
                    public void onChanged(@Nullable final List<Team> teams) {
                        adapter.setTeams(teams);
                    }
                });

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        FloatingActionButton nextFab = findViewById(R.id.fab_next);
        nextFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : go to next activity (do not forget to pass race id param)
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_team, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_new_team:
                NewTeamDialog newTeamDialog = NewTeamDialog.newInstance(raceId);
                newTeamDialog.show(Objects.requireNonNull(getSupportFragmentManager()),
                        NEW_TEAM_DIALOG_CODE);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
