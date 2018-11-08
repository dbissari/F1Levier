package com.rebels.f1levier.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.rebels.f1levier.db.entity.ParticipantEntity;

import java.util.List;

@Dao
public interface ParticipantDao {
    @Query("SELECT * FROM participant")
    LiveData<List<ParticipantEntity>> getAll();

    @Query("SELECT * FROM participant WHERE id IN (:ids)")
    List<ParticipantEntity> getAllByIds(final int[] ids);

    @Query("SELECT * FROM participant WHERE id = :id")
    ParticipantEntity getById(final int id);

    @Insert
    void insert(ParticipantEntity participantEntity);
}
