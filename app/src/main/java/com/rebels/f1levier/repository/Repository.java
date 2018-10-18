package com.rebels.f1levier.repository;

import io.realm.Realm;

abstract class Repository {
    Realm mRealm;

    Repository(Realm realm) {
        mRealm = realm;
    }
}
