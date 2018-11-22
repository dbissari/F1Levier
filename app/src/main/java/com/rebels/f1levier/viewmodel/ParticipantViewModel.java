package com.rebels.f1levier.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.rebels.f1levier.db.entity.Participant;
import com.rebels.f1levier.repository.ParticipantRepository;

import java.util.List;

public class ParticipantViewModel extends AndroidViewModel {

    private ParticipantRepository mRepository;

    private LiveData<List<Participant>> mAllParticipants;

    public ParticipantViewModel(Application application) {
        super(application);
        mRepository = new ParticipantRepository(application);
        mAllParticipants = mRepository.getAllParticipants();
    }

    public LiveData<List<Participant>> getAllParticipants() {
        return mAllParticipants;
    }

    public void insert(Participant participant) {
        mRepository.insert(participant);
    }
}
