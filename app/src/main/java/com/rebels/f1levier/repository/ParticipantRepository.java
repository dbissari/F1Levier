package com.rebels.f1levier.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.rebels.f1levier.db.AppDatabase;
import com.rebels.f1levier.db.dao.ParticipantDao;
import com.rebels.f1levier.db.entity.Participant;

import java.util.List;

public class ParticipantRepository {

    private ParticipantDao mParticipantDao;

    private LiveData<List<Participant>> mAllParticipants;

    public ParticipantRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mParticipantDao = db.participantDao();
        mAllParticipants = mParticipantDao.getAll();
    }

    public LiveData<List<Participant>> getAllParticipants() {
        return mAllParticipants;
    }

    public void insert(Participant participant) {
        new insertAsyncTask(mParticipantDao).execute(participant);
    }

    private static class insertAsyncTask extends AsyncTask<Participant, Void, Void> {

        private ParticipantDao mAsyncTaskDao;

        insertAsyncTask(ParticipantDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Participant... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
