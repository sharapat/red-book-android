package com.dasturlash.redbook.favorites;

import com.dasturlash.redbook.models.AnimalDbModel;
import com.dasturlash.redbook.room.AnimalDao;

import java.util.List;

public class FavoritePresenter {
    private AnimalDao animalDao;
    private FavoritesView favoritesView;

    public FavoritePresenter(AnimalDao animalDao, FavoritesView favoritesView) {
        this.animalDao = animalDao;
        this.favoritesView = favoritesView;
    }

    public void getFavorites() {
        List<AnimalDbModel> favorites = animalDao.getFavorites();
        if (favorites.isEmpty()) {
            favoritesView.isFavoriteEmpty(true);
        } else {
            favoritesView.isFavoriteEmpty(false);
            favoritesView.updateAdapter(favorites);
        }
    }
}
