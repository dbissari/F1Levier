package com.rebels.f1levier.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "participant")
public class Participant {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

    public int echelon;

    public Participant(@NonNull String name, int echelon) {
        this.name = name;
        this.echelon = echelon;
    }
}
