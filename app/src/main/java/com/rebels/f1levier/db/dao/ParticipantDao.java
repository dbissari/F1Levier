package com.rebels.f1levier.db.dao;

import com.rebels.f1levier.db.entities.Participant;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ParticipantDao {
    @Query("SELECT * FROM participant")
    List<Participant> getAll();

    @Query("SELECT * FROM participant WHERE id IN (:ids)")
    List<Participant> getAllByIds(final int[] ids);

    @Query("SELECT * FROM participant WHERE id = :id")
    Participant getById(final int id);

    @Insert
    void insert(Participant participant);
}
