package com.dasturlash.redbook.animals;

import com.dasturlash.redbook.holder.AnimalHolder;
import com.dasturlash.redbook.models.AnimalDbModel;
import com.dasturlash.redbook.room.AnimalDao;

import java.util.List;

public class AnimalsPresenter {
    private AnimalsView animalsView;
    private AnimalDao animalDao;
    private int type;

    AnimalsPresenter(AnimalsView animalsView, AnimalDao animalDao) {
        this.animalsView = animalsView;
        this.animalDao = animalDao;
    }

    public void getData(int type) {
        this.type = type;
        List<AnimalDbModel> models = AnimalHolder.getInstance().getAnimalsByType(type);
        animalsView.showAnimalsList();
        animalsView.hideAnimalsNotFoundMessage();
        animalsView.updateAdapter(models);
    }

    public void searchAnimalsByName(String name) {
        List<AnimalDbModel> result = animalDao.searchAnimalsByName(type, name + "%");
        if (result.isEmpty()) {
            animalsView.hideAnimalsList();
            animalsView.showAnimalsNotFoundMessage();
        } else {
            animalsView.hideAnimalsNotFoundMessage();
            animalsView.showAnimalsList();
            animalsView.updateAdapter(result);
        }
    }
}
