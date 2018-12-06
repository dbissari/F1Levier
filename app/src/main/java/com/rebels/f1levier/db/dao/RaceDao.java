package com.rebels.f1levier.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.rebels.f1levier.db.entity.Race;

import java.util.List;

@Dao
public interface RaceDao {

    @Query("SELECT * FROM Race WHERE id = :id")
    Race getById(final int id);

    @Query("SELECT * FROM Race WHERE started_at IS NULL")
    LiveData<List<Race>> getAllNotStarted();

    @Query("SELECT * FROM Race WHERE started_at IS NOT NULL")
    LiveData<List<Race>> getAllStarted();

    @Insert
    long insert(Race race);
}
