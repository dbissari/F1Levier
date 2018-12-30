package com.rebels.f1levier.db.dao.QueryResult;

import android.arch.persistence.room.ColumnInfo;

public class TeamDetail {
    public int id;
    public String name;
    public int membersCount;
    public int echelonsSum;
    @ColumnInfo(name = "race_id")
    public int raceId;
}
