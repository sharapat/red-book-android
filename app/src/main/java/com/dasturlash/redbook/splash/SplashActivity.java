package com.dasturlash.redbook.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.dasturlash.redbook.MainActivity;
import com.dasturlash.redbook.helper.GsonHelper;
import com.dasturlash.redbook.helper.SharedPrefsHelper;
import com.dasturlash.redbook.helper.thread.AppExecutors;
import com.dasturlash.redbook.room.AnimalDatabase;

public class SplashActivity extends AppCompatActivity implements SplashView {
    private AnimalDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GsonHelper gsonHelper = new GsonHelper(this, "book.json");
        SharedPrefsHelper prefsHelper = new SharedPrefsHelper(this);
        database = AnimalDatabase.getAnimalDatabase(this);

        SplashPresenter presenter = new SplashPresenter(this, gsonHelper, prefsHelper, database.animalDao(), new AppExecutors());
        presenter.startSplash();
    }

    @Override
    public void goToMainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
