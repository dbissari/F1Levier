package com.rebels.f1levier.repository;

import android.support.annotation.NonNull;

import com.rebels.f1levier.model.Level;

import io.realm.Realm;
import io.realm.RealmResults;

public class LevelRepository extends Repository {

    public LevelRepository(Realm realm) {
        super(realm);
    }

    public void add(final Level level) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(@NonNull Realm realm) {
                realm.copyToRealm(level);
            }
        });
    }

    public RealmResults<Level> getAll() {
        return mRealm.where(Level.class)
                .findAll();
    }

    public Level get(String id) {
        return mRealm.where(Level.class)
                .equalTo("id", id)
                .findFirst();
    }
}
