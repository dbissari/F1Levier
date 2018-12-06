package com.rebels.f1levier.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.rebels.f1levier.db.AppDatabase;
import com.rebels.f1levier.db.dao.RaceDao;
import com.rebels.f1levier.db.entity.Race;

import java.util.List;

public class RaceRepository {

    private RaceDao mRaceDao;

    private LiveData<List<Race>> mStartedRaces;

    private LiveData<List<Race>> mNotStartedRaces;

    public RaceRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mRaceDao = db.raceDao();
        mStartedRaces = mRaceDao.getAllStarted();
        mNotStartedRaces = mRaceDao.getAllNotStarted();
    }

    public LiveData<List<Race>> getStartedRaces() {
        return mStartedRaces;
    }

    public LiveData<List<Race>> getNotStartedRaces() {
        return mNotStartedRaces;
    }

    public long insertSync(Race race) {
        return mRaceDao.insert(race);
    }
}
