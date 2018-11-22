package com.rebels.f1levier.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.rebels.f1levier.db.entity.Race;

@Dao
public interface RaceDao {

    @Query("SELECT * FROM Race WHERE id = :id")
    Race getById(final int id);

    @Insert
    void insert(Race race);
}
