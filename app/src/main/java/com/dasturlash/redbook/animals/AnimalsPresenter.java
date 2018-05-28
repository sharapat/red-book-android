package com.dasturlash.redbook.animals;

import com.dasturlash.redbook.models.AnimalDbModel;
import com.dasturlash.redbook.room.AnimalDao;

import java.util.List;

public class AnimalsPresenter {
    private AnimalDao animalDao;
    private AnimalsView animalsView;
    private int type;

    AnimalsPresenter(AnimalDao animalDao, AnimalsView animalsView) {
        this.animalDao = animalDao;
        this.animalsView = animalsView;
    }

    public void getData(int type) {
        this.type = type;
        List<AnimalDbModel> models = animalDao.getAnimalsByType(type);
        animalsView.updateAdapter(models);
    }
}
