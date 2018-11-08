package com.rebels.f1levier.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.rebels.f1levier.db.entity.RaceEntity;

@Dao
public interface RaceDao {

    @Query("SELECT * FROM race WHERE id = :id")
    RaceEntity getById(final int id);

    @Insert
    void insert(RaceEntity raceEntity);
}
