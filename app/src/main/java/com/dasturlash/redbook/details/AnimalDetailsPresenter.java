package com.dasturlash.redbook.details;

import com.dasturlash.redbook.R;
import com.dasturlash.redbook.models.AnimalDbModel;
import com.dasturlash.redbook.room.AnimalDao;

public class AnimalDetailsPresenter {
    private AnimalDetailsView animalDetailsView;
    private AnimalDao animalDao;
    private AnimalDbModel model;

    AnimalDetailsPresenter(AnimalDetailsView animalDetailsView, AnimalDao animalDao) {
        this.animalDetailsView = animalDetailsView;
        this.animalDao = animalDao;
    }

    public void getAnimalDetails(int id) {
        model = animalDao.getAnimalById(id);
        animalDetailsView.setAnimalDetail(model);
    }

    public void setFavoriteStatus() {
        if (model == null) return;
        if (model.isFavorite()) {
            animalDetailsView.setFavoriteIcon(R.drawable.ic_bookmark_white_24dp);
        } else {
            animalDetailsView.setFavoriteIcon(R.drawable.ic_bookmark_border_black_24dp);
        }
    }

    public void toggleFavorite() {
        if (model != null) {
            boolean isFavorite = !model.isFavorite();
            model.setFavorite(isFavorite);
            animalDao.update(model);
            setFavoriteStatus();
        }
    }
}
