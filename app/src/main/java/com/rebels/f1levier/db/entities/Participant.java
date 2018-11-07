package com.rebels.f1levier.db.entities;

import android.support.annotation.NonNull;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Participant {

    @PrimaryKey
    @NonNull
    public int id;

    public String name;

    public int level;
}
