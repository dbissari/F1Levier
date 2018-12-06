package com.rebels.f1levier.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "participant")
public class Participant {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    public String name;

    @NonNull
    public int echelon;

    @Ignore
    public Participant() {
    }

    public Participant(@NonNull String name, @NonNull int echelon) {
        this.name = name;
        this.echelon = echelon;
    }
}
