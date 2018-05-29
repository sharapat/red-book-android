package com.dasturlash.redbook.favorites;

import com.dasturlash.redbook.models.AnimalDbModel;
import com.dasturlash.redbook.room.AnimalDao;

import java.util.List;

public class FavoritePresenter {
    private AnimalDao animalDao;
    private FavoritesView favoritesView;

    FavoritePresenter(AnimalDao animalDao, FavoritesView favoritesView) {
        this.animalDao = animalDao;
        this.favoritesView = favoritesView;
    }

    public void getFavorites() {
        List<AnimalDbModel> favorites = animalDao.getFavorites();
        if (favorites.isEmpty()) {
            favoritesView.showEmptyMessage();
            favoritesView.hideNotFoundMessage();
            favoritesView.hideFavoritesList();
        } else {
            favoritesView.hideNotFoundMessage();
            favoritesView.hideEmptyMessage();
            favoritesView.showFavoritesList();
            favoritesView.updateAdapter(favorites);
        }
    }

    public void searchFavoritesByName(String name) {
        List<AnimalDbModel> result = animalDao.searchFavoritesByName(name + "%");
        if (result.isEmpty()) {
            favoritesView.hideEmptyMessage();
            favoritesView.hideFavoritesList();
            favoritesView.showNotFoundMessage();
        } else {
            favoritesView.hideEmptyMessage();
            favoritesView.hideNotFoundMessage();
            favoritesView.showFavoritesList();
            favoritesView.updateAdapter(result);
        }
    }

}
