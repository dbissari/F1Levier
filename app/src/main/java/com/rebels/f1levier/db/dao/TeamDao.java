package com.rebels.f1levier.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.rebels.f1levier.db.entity.TeamEntity;

import java.util.List;

@Dao
public interface TeamDao {

    @Query("SELECT * FROM team WHERE race_id = :raceId")
    List<TeamEntity> getAllByRaceId(final int raceId);

    @Insert
    void insert(TeamEntity teamEntity);
}
