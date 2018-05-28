package com.dasturlash.redbook.animals;

import com.dasturlash.redbook.models.AnimalDbModel;
import com.dasturlash.redbook.room.AnimalDao;

import java.util.List;

public class AnimalsPresenter {
    private AnimalDao animalDao;
    private AnimalsView animalsView;
    private int type;

    AnimalsPresenter(AnimalDao animalDao, AnimalsView animalsView, int type) {
        this.animalDao = animalDao;
        this.animalsView = animalsView;
        this.type = type;
    }

    public void getData() {
        List<AnimalDbModel> models = animalDao.getAnimalsByType(type);
        animalsView.updateAdapter(models);
    }
}
