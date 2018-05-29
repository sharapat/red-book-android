package com.dasturlash.redbook.favorites;

import com.dasturlash.redbook.models.AnimalDbModel;

import java.util.List;

public interface FavoritesView {
    void updateAdapter(List<AnimalDbModel> models);
    void showEmptyMessage();
    void hideEmptyMessage();
    void showNotFoundMessage();
    void hideNotFoundMessage();
    void showFavoritesList();
    void hideFavoritesList();
}
