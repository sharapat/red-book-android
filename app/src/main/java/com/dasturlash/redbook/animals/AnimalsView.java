package com.dasturlash.redbook.animals;

import com.dasturlash.redbook.models.AnimalDbModel;

import java.util.List;

public interface AnimalsView {
    void updateAdapter(List<AnimalDbModel> models);
    void hideAnimalsList();
    void showAnimalsList();
    void showAnimalsNotFoundMessage();
    void hideAnimalsNotFoundMessage();
}
