package com.dasturlash.redbook.splash;

import com.dasturlash.redbook.MainActivity;
import com.dasturlash.redbook.helper.GsonHelper;
import com.dasturlash.redbook.helper.SharedPrefsHelper;
import com.dasturlash.redbook.helper.thread.AppExecutors;
import com.dasturlash.redbook.holder.AnimalHolder;
import com.dasturlash.redbook.models.AnimalDbModel;
import com.dasturlash.redbook.room.AnimalDao;

import java.util.List;

/**
 * Created by QAREKEN on 5/26/2018.
 */

public class SplashPresenter {
    private final SplashView view;
    private final GsonHelper gsonHelper;
    private final SharedPrefsHelper prefsManager;
    private final AnimalDao animalDao;
    private AppExecutors appExecutors;

    SplashPresenter(SplashView view, GsonHelper gsonHelper, SharedPrefsHelper prefsManager, AnimalDao animalDao,
                    AppExecutors appExecutors) {
        this.view = view;
        this.gsonHelper = gsonHelper;
        this.prefsManager = prefsManager;
        this.animalDao = animalDao;
        this.appExecutors = appExecutors;
    }

    void startSplash() {
        appExecutors.getDiskIo().execute(new Runnable() {
            @Override
            public void run() {
                if (prefsManager.isFirstLaunch()) {
                    animalDao.insertToDB(gsonHelper.getListFromLocalAssets());
                    prefsManager.setFirstLaunch();
                }
                List<AnimalDbModel> models = animalDao.getAnimalsByType(MainActivity.INVERTEBRATES);
                AnimalHolder.getInstance().setInvertebratesList(models);
                models = animalDao.getAnimalsByType(MainActivity.FISHES);
                AnimalHolder.getInstance().setFishesList(models);
                models = animalDao.getAnimalsByType(MainActivity.REPTILES);
                AnimalHolder.getInstance().setReptilesList(models);
                models = animalDao.getAnimalsByType(MainActivity.BIRDS);
                AnimalHolder.getInstance().setBirdsList(models);
                models = animalDao.getAnimalsByType(MainActivity.MAMMALS);
                AnimalHolder.getInstance().setMammalsList(models);
                models = animalDao.getAllAnimals();
                AnimalHolder.getInstance().setAllAnimals(models);
                appExecutors.getMainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        view.goToMainScreen();
                    }
                });
            }
        });
    }
}
