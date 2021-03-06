package com.rebels.f1levier.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.rebels.f1levier.db.entity.Race;
import com.rebels.f1levier.repository.RaceRepository;

import java.util.List;

public class RaceViewModel extends AndroidViewModel {

    private RaceRepository mRaceRepository;

    private LiveData<List<Race>> mNotStartedRaces;

    private LiveData<List<Race>> mFinishedRaces;

    public RaceViewModel(Application application) {
        super(application);
        mRaceRepository = new RaceRepository(application);
        mNotStartedRaces = mRaceRepository.getNotStartedRaces();
        mFinishedRaces = mRaceRepository.getFinishedRaces();
    }

    public LiveData<List<Race>> getNotStartedRaces() {
        return mNotStartedRaces;
    }

    public LiveData<List<Race>> getFinishedRaces() {
        return mFinishedRaces;
    }

    public Long insertSync(Race race) {
        return mRaceRepository.insertSync(race);
    }
}
