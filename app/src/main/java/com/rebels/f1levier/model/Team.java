package com.rebels.f1levier.model;

import java.util.UUID;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Team extends RealmObject {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    private String name;

    private RealmList<Participant> members;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                // TODO : Add members
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

    public RealmList<Participant> getMembers() {
        return members;
    }

    public void setMembers(RealmList<Participant> members) {
        this.members = members;
    }
}
