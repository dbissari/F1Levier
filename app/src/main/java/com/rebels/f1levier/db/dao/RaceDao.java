package com.rebels.f1levier.db.dao;

import com.rebels.f1levier.db.entities.Race;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface RaceDao {

    @Query("SELECT * FROM race WHERE id = :id")
    Race getById(final int id);

    @Insert
    void insert(Race race);
}
