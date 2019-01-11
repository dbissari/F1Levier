package com.rebels.f1levier.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.rebels.f1levier.db.dao.QueryResult.ParticipantStat;
import com.rebels.f1levier.db.dao.QueryResult.TeamStat;
import com.rebels.f1levier.repository.MeasuredTimeRepository;

import java.util.List;

public class StatsViewModel extends AndroidViewModel {

    private MeasuredTimeRepository mMeasuredTimeRepository;

    public StatsViewModel(@NonNull Application application) {
        super(application);
        mMeasuredTimeRepository = new MeasuredTimeRepository(application);
    }

    public List<TeamStat> getTeamStatsByRaceId(int raceId) {
        return mMeasuredTimeRepository.getTeamStatsByRaceId(raceId);
    }

    public List<ParticipantStat> getParticipantStatsByRaceId(int raceId) {
        return mMeasuredTimeRepository.getParticipantStatsByRaceId(raceId);
    }
}
