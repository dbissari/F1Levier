package com.rebels.f1levier.model;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.Ignore;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class Participant extends RealmObject {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    private String name;

    private Level level;

    @Ignore
    private boolean checked = false;

    @LinkingObjects("members")
    private final RealmResults<Team> teams = null;

    public Participant() {
    }

    public Participant(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public String toString() {
        /*
        return "Participant{" +
                "id=" + id +
                ",name=" + name +
                ",level=" + level.getName() +
                '}';
        */
        return name + " (" + level.getName() + ")";
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

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
