package com.rebels.f1levier.model;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class Participant extends RealmObject {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    private String name;

    private Level level;

    @LinkingObjects("members")
    private final RealmResults<Team> teams = null;

    public Participant(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", level=" + level.getName() +
                // TODO : Add team
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public RealmResults<Team> getTeams() {
        return teams;
    }
}
