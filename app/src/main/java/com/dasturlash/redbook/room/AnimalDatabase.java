package com.dasturlash.redbook.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.dasturlash.redbook.models.AnimalDbModel;

/**
 * Created by QAREKEN on 5/26/2018.
 */
@Database(entities = {AnimalDbModel.class}, version = 1, exportSchema = false)
public abstract class AnimalDatabase extends RoomDatabase {
    private static AnimalDatabase instance;

    public static AnimalDatabase getAnimalDatabase(Context context) {
        if (instance == null) {
            instance = Room
                    .databaseBuilder(context.getApplicationContext(), AnimalDatabase.class, "book-database")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public static void destroyInstance() {
        instance = null;
    }

    public abstract AnimalDao animalDao();
}
