package com.dasturlash.redbook.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.dasturlash.redbook.models.AnimalDbModel;

import java.util.List;

/**
 * Created by QAREKEN on 5/26/2018.
 */

@Dao
public interface AnimalDao {

    @Query("SELECT * FROM book")
    List<AnimalDbModel> getAllAnimals();

    @Query("SELECT * FROM book WHERE type = :type")
    List<AnimalDbModel> getAnimalsByType(int type);

    @Query("SELECT * FROM book WHERE id = :id")
    AnimalDbModel getAnimalById(int id);

    @Query("SELECT * FROM book WHERE type = :type AND nameUzb LIKE :name")
    List<AnimalDbModel> searchAnimalsByName(int type, String name);

    @Query("SELECT * FROM book WHERE favorite = 1")
    List<AnimalDbModel> getFavorites();

    @Query("SELECT * FROM book WHERE favorite = 1 AND nameUzb LIKE :name")
    List<AnimalDbModel> searchFavoritesByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertToDB(List<AnimalDbModel> models);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(AnimalDbModel sozlikDbModel);

}
