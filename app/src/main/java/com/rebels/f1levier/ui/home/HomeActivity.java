package com.rebels.f1levier.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.rebels.f1levier.R;
import com.rebels.f1levier.model.Level;
import com.rebels.f1levier.model.Participant;
import com.rebels.f1levier.model.Team;
import com.rebels.f1levier.ui.levels.LevelsFragment;
import com.rebels.f1levier.ui.participants.ParticipantsFragment;
import com.rebels.f1levier.ui.runs.RunsFragment;
import com.rebels.f1levier.ui.teams.TeamsFragment;

public class HomeActivity extends AppCompatActivity implements LevelsFragment.OnListFragmentInteractionListener, TeamsFragment.OnListFragmentInteractionListener, ParticipantsFragment.OnListFragmentInteractionListener {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_runs:
                    showFragment(new RunsFragment());
                    return true;
                case R.id.navigation_participants:
                    showFragment(new ParticipantsFragment());
                    return true;
                case R.id.navigation_teams:
                    showFragment(new TeamsFragment());
                    return true;
                case R.id.navigation_levels:
                    showFragment(new LevelsFragment());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        showFragment(new RunsFragment());
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }

    @Override
    public void onListFragmentInteraction(Level level) {

    }

    @Override
    public void onListFragmentInteraction(Team team) {

    }

    @Override
    public void onListFragmentInteraction(Participant participant) {

    }
}