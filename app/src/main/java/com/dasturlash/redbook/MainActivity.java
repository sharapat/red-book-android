package com.dasturlash.redbook;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.dasturlash.redbook.animals.AnimalsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final int INVERTEBRATES = 1;
    public static final int FISHES = 2;
    public static final int REPTILES = 3;
    public static final int BIRDS = 4;
    public static final int MAMMALS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        changeFragment(new AnimalsFragment(), AnimalsFragment.TAG);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_invertebrates) {
            showAnimalsFragment(INVERTEBRATES);
        } else if (id == R.id.nav_fishes) {
            showAnimalsFragment(FISHES);
        } else if (id == R.id.nav_reptiles) {
            showAnimalsFragment(REPTILES);
        } else if (id == R.id.nav_birds) {
            showAnimalsFragment(BIRDS);
        } else if (id == R.id.nav_mammals) {
            showAnimalsFragment(MAMMALS);
        } else if (id == R.id.nav_favorites) {

        } else if (id == R.id.nav_author) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void changeFragment(Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment, tag).commit();
    }

    private void showAnimalsFragment(int type) {
        AnimalsFragment fragment = (AnimalsFragment) getSupportFragmentManager().findFragmentByTag(AnimalsFragment.TAG);
        if (fragment != null && fragment.isVisible()) {
            fragment.getData(type);
        } else {
            Bundle bundle = new Bundle();
            bundle.putInt(AnimalsFragment.TYPE_ARGUMENT_KEY, type);
            assert fragment != null;
            fragment.setArguments(bundle);
            changeFragment(fragment, AnimalsFragment.TAG);
        }
    }
}
