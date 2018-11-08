package com.rebels.f1levier.db.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "team",
        foreignKeys = { @ForeignKey(entity = RaceEntity.class,
                parentColumns = "id",
                childColumns = "race_id")})
public class TeamEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    public String name;

    @NonNull
    @ColumnInfo(name="race_id")
    public int raceId;
}
