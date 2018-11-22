package com.rebels.f1levier.db.entity;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "race")
public class Race {

    @PrimaryKey(autoGenerate = true)
    public int id;
}
