package com.rebels.f1levier.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.rebels.f1levier.db.entity.Team;

import java.util.List;

@Dao
public interface TeamDao {

    @Query("SELECT * FROM Team WHERE race_id = :raceId")
    LiveData<List<Team>> getAllByRaceId(final int raceId);

    @Insert
    Long insert(Team team);
}
