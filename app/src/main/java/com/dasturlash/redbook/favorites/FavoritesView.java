package com.dasturlash.redbook.favorites;

import com.dasturlash.redbook.models.AnimalDbModel;

import java.util.List;

public interface FavoritesView {
    void isFavoriteEmpty(boolean isEmpty);
    void updateAdapter(List<AnimalDbModel> models);
}
