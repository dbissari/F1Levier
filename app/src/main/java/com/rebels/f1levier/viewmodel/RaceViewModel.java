package com.rebels.f1levier.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.rebels.f1levier.db.entity.Race;
import com.rebels.f1levier.repository.RaceRepository;

import java.util.List;

public class RaceViewModel extends AndroidViewModel {

    private RaceRepository mRaceRepository;

    private LiveData<List<Race>> mStartedRaces;

    private LiveData<List<Race>> mNotStartedRaces;

    public RaceViewModel(Application application) {
        super(application);
        mRaceRepository = new RaceRepository(application);
        mStartedRaces = mRaceRepository.getStartedRaces();
        mNotStartedRaces = mRaceRepository.getNotStartedRaces();
    }

    public LiveData<List<Race>> getStartedRaces() {
        return mStartedRaces;
    }

    public LiveData<List<Race>> getNotStartedRaces() {
        return mNotStartedRaces;
    }

    public long insertSync(Race race) {
        return mRaceRepository.insertSync(race);
    }
}
