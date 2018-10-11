package com.rebels.f1levier.model;

import io.realm.RealmObject;

public class Level extends RealmObject {

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
        return "Level{" +
                "name=" + name +
                "echelon=" + echelon +
                '}';
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
