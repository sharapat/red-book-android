package com.dasturlash.redbook.details;

import com.dasturlash.redbook.models.AnimalDbModel;

public interface AnimalDetailsView {
    void setAnimalDetail(AnimalDbModel model);
    void setFavoriteIcon(int resId);
}
