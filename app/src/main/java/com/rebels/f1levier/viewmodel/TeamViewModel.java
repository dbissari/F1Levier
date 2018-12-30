package com.rebels.f1levier.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.rebels.f1levier.db.entity.Team;
import com.rebels.f1levier.repository.TeamRepository;

import java.util.List;

public class TeamViewModel extends AndroidViewModel {

    private TeamRepository mTeamRepository;

    public TeamViewModel(Application application) {
        super(application);
        mTeamRepository = new TeamRepository(application);
    }

    public LiveData<List<Team>> getTeamsByRaceId(int raceId) {
        return mTeamRepository.getTeamsByRaceId(raceId);
    }

    public Long insertSync(Team team) {
        return mTeamRepository.insertSync(team);
    }
}
