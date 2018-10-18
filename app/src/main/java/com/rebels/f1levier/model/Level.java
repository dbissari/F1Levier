package com.rebels.f1levier.model;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Level extends RealmObject {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    private String name;

    private int echelon;

    public Level() {
    }

    public Level(String name, int echelon) {
        this.name = name;
        this.echelon = echelon;
    }

    @Override
    public String toString() {
        /*
        return "Level{" +
                "id=" + id +
                ",name=" + name +
                ",echelon=" + echelon +
                '}';
        */
        return name + " (" + echelon + ")";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEchelon() {
        return echelon;
    }

    public void setEchelon(int echelon) {
        this.echelon = echelon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
