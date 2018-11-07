package com.rebels.f1levier.db.dao;

import com.rebels.f1levier.db.entities.Team;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface TeamDao {

    @Query("SELECT * FROM team WHERE race_id = :raceId")
    List<Team> getByRace(final int raceId);

    @Insert
    void insert(Team team);
}
