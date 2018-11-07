package com.rebels.f1levier.db.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = { @ForeignKey(entity = Race.class,
                parentColumns = "id",
                childColumns = "raceId")})
public class Team {

    @PrimaryKey
    public int id;

    public String name;

    public int raceId;
}
