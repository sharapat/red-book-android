package com.dasturlash.redbook.holder;

import com.dasturlash.redbook.models.AnimalDbModel;

import java.util.List;

/**
 * Created by QAREKEN on 5/26/2018.
 */

public class AnimalHolder {
    private static AnimalHolder instance;
    private List<AnimalDbModel> invertebratesList;
    private List<AnimalDbModel> fishesList;
    private List<AnimalDbModel> reptilesList;
    private List<AnimalDbModel> birdsList;
    private List<AnimalDbModel> mammalsList;
    private List<AnimalDbModel> allAnimals;

    private AnimalHolder() {
    }

    public static AnimalHolder getInstance() {
        if (instance == null) {
            instance = new AnimalHolder();
        }
        return instance;
    }

    public List<AnimalDbModel> getInvertebratesList() {
        return invertebratesList;
    }

    public void setInvertebratesList(List<AnimalDbModel> invertebratesList) {
        this.invertebratesList = invertebratesList;
    }

    public List<AnimalDbModel> getFishesList() {
        return fishesList;
    }

    public void setFishesList(List<AnimalDbModel> fishesList) {
        this.fishesList = fishesList;
    }

    public List<AnimalDbModel> getReptilesList() {
        return reptilesList;
    }

    public void setReptilesList(List<AnimalDbModel> reptilesList) {
        this.reptilesList = reptilesList;
    }

    public List<AnimalDbModel> getBirdsList() {
        return birdsList;
    }

    public void setBirdsList(List<AnimalDbModel> birdsList) {
        this.birdsList = birdsList;
    }

    public List<AnimalDbModel> getMammalsList() {
        return mammalsList;
    }

    public void setMammalsList(List<AnimalDbModel> mammalsList) {
        this.mammalsList = mammalsList;
    }

    public void getAnimalsByType(int type) {
    }

    public static void setInstance(AnimalHolder instance) {
        AnimalHolder.instance = instance;
    }

    public List<AnimalDbModel> getAllAnimals() {
        return allAnimals;
    }

    public void setAllAnimals(List<AnimalDbModel> allAnimals) {
        this.allAnimals = allAnimals;
    }
}
