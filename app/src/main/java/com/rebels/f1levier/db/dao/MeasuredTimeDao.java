package com.rebels.f1levier.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import com.rebels.f1levier.db.entity.MeasuredTime;

@Dao
public interface MeasuredTimeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MeasuredTime measuredTime);
}
