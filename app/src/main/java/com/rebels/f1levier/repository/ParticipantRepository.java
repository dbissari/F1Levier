package com.rebels.f1levier.repository;

import android.support.annotation.NonNull;

import com.rebels.f1levier.model.Participant;

import io.realm.Realm;
import io.realm.RealmResults;

public class ParticipantRepository extends Repository {

    public ParticipantRepository(Realm realm) {
        super(realm);
    }

    public void add(final Participant participant) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(@NonNull Realm realm) {
                // TODO : Look for another way to do without update option
                realm.copyToRealmOrUpdate(participant);
            }
        });
    }

    public RealmResults<Participant> getAll() {
        return mRealm.where(Participant.class)
                .findAll();
    }
}
