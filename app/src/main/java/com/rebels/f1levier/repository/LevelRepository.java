package com.rebels.f1levier.repository;

import android.support.annotation.NonNull;

import com.rebels.f1levier.model.Level;

import java.util.List;

import io.realm.Realm;

public class LevelRepository {
    private Realm mRealm;

    public LevelRepository(Realm realm) {
        mRealm = realm;
    }

    public void add(final Level level) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(@NonNull Realm realm) {
                realm.copyToRealm(level);
            }
        });
    }

    public List<Level> getAll() {
        return mRealm.where(Level.class).findAll();
    }
}
