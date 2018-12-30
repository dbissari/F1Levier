package com.rebels.f1levier.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.rebels.f1levier.db.AppDatabase;
import com.rebels.f1levier.db.dao.TeamDao;
import com.rebels.f1levier.db.entity.Team;

import java.util.List;

public class TeamRepository {

    private TeamDao mTeamDao;

    public TeamRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mTeamDao = db.teamDao();
    }

    public LiveData<List<Team>> getTeamsByRaceId(int raceId) {
        return mTeamDao.getAllByRaceId(raceId);
    }

    public Long insertSync(Team team) {
        return mTeamDao.insert(team);
    }
}
