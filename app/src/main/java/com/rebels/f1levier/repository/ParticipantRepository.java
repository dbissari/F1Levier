package com.rebels.f1levier.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.rebels.f1levier.db.AppDatabase;
import com.rebels.f1levier.db.dao.ParticipantDao;
import com.rebels.f1levier.db.entity.ParticipantEntity;

import java.util.List;

public class ParticipantRepository {

    private ParticipantDao mParticipantDao;

    private LiveData<List<ParticipantEntity>> mAllParticipants;

    public ParticipantRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mParticipantDao = db.participantDao();
        mAllParticipants = mParticipantDao.getAll();
    }

    public LiveData<List<ParticipantEntity>> getAllParticipants() {
        return mAllParticipants;
    }

    public void insert(ParticipantEntity participantEntity) {
        new insertAsyncTask(mParticipantDao).execute(participantEntity);
    }

    private static class insertAsyncTask extends AsyncTask<ParticipantEntity, Void, Void> {

        private ParticipantDao mAsyncTaskDao;

        insertAsyncTask(ParticipantDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ParticipantEntity... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
