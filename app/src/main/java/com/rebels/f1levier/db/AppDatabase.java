package com.rebels.f1levier.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.rebels.f1levier.db.dao.ParticipantDao;
import com.rebels.f1levier.db.dao.RaceDao;
import com.rebels.f1levier.db.dao.TeamDao;
import com.rebels.f1levier.db.dao.TeamMemberJoinDao;
import com.rebels.f1levier.db.entity.ParticipantEntity;
import com.rebels.f1levier.db.entity.RaceEntity;
import com.rebels.f1levier.db.entity.TeamEntity;
import com.rebels.f1levier.db.entity.TeamMemberJoinEntity;

@Database(entities = {ParticipantEntity.class, TeamEntity.class, TeamMemberJoinEntity.class, RaceEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract ParticipantDao participantDao();

    public abstract TeamDao teamDao();

    public abstract TeamMemberJoinDao teamMemberJoinDao();

    public abstract RaceDao raceDao();

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "app_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
