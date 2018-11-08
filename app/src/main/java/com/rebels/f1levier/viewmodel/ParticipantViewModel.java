package com.rebels.f1levier.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.rebels.f1levier.db.entity.ParticipantEntity;
import com.rebels.f1levier.repository.ParticipantRepository;

import java.util.List;

public class ParticipantViewModel extends AndroidViewModel {

    private ParticipantRepository mRepository;

    private LiveData<List<ParticipantEntity>> mAllParticipants;

    public ParticipantViewModel(Application application) {
        super(application);
        mRepository = new ParticipantRepository(application);
        mAllParticipants = mRepository.getAllParticipants();
    }

    public LiveData<List<ParticipantEntity>> getAllParticipants() {
        return mAllParticipants;
    }
    public void insert(ParticipantEntity participant) {
        mRepository.insert(participant);
    }
}
