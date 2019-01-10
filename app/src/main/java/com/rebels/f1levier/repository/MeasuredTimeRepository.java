package com.rebels.f1levier.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.rebels.f1levier.db.AppDatabase;
import com.rebels.f1levier.db.dao.MeasuredTimeDao;
import com.rebels.f1levier.db.entity.MeasuredTime;

public class MeasuredTimeRepository {

    private MeasuredTimeDao mMeasuredTimeDao;

    public MeasuredTimeRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mMeasuredTimeDao = db.measuredTimeDao();
    }

    public void insertAsync(MeasuredTime measuredTime) {
        new insertAsyncTask(mMeasuredTimeDao).execute(measuredTime);
    }

    private static class insertAsyncTask extends AsyncTask<MeasuredTime, Void, Void> {

        private MeasuredTimeDao mAsyncTaskDao;

        insertAsyncTask(MeasuredTimeDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final MeasuredTime... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
