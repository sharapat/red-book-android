package com.dasturlash.redbook;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;

import com.dasturlash.redbook.animals.AnimalsFragment;
import com.dasturlash.redbook.favorites.FavoritesFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final int INVERTEBRATES = 1;
    public static final int FISHES = 2;
    public static final int REPTILES = 3;
    public static final int BIRDS = 4;
    public static final int MAMMALS = 5;

    private DrawerLayout drawer;
    private InputMethodManager inputMethodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
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

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) searchItem.getActionView();
        assert searchManager != null;
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(onQueryTextListener);
        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                getInputMethodManager().toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
                searchView.requestFocusFromTouch();
                searchView.setQuery("", false);
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                getInputMethodManager().hideSoftInputFromWindow(drawer.getWindowToken(), 0);
                AnimalsFragment animalsFragment = (AnimalsFragment) getSupportFragmentManager().findFragmentByTag(AnimalsFragment.TAG);
                FavoritesFragment favoritesFragment = (FavoritesFragment) getSupportFragmentManager().findFragmentByTag(FavoritesFragment.TAG);
                if (animalsFragment != null && animalsFragment.isVisible()) {
                    animalsFragment.getData(animalsFragment.getType());
                } else if (favoritesFragment != null && favoritesFragment.isVisible()) {
                    favoritesFragment.getFavorites();
                }
                return true;
            }
        });
        searchView.setIconifiedByDefault(false);
        searchView.requestFocus();
        return true;
    }

    SearchView.OnQueryTextListener onQueryTextListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            AnimalsFragment animalsFragment = (AnimalsFragment) getSupportFragmentManager().findFragmentByTag(AnimalsFragment.TAG);
            FavoritesFragment favoritesFragment = (FavoritesFragment) getSupportFragmentManager().findFragmentByTag(FavoritesFragment.TAG);
            if (animalsFragment != null && animalsFragment.isVisible()) {
                animalsFragment.searchAnimalsByName(newText);
            } else if (favoritesFragment != null && favoritesFragment.isVisible()) {
                favoritesFragment.searchFavoritesByName(newText);
            } else {
                return false;
            }
            return true;
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

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
            changeFragment(new FavoritesFragment(), FavoritesFragment.TAG);
        } else if (id == R.id.nav_author) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void changeFragment(Fragment fragment, String tag) {
        ActionBar actionBar = getSupportActionBar();
        if (tag.equals(FavoritesFragment.TAG) && actionBar != null && actionBar.getTitle() != getString(R.string.favorites)) {
            actionBar.setTitle(R.string.favorites);
        } else if (tag.equals(AnimalsFragment.TAG) && actionBar != null && actionBar.getTitle() != getString(R.string.app_name)) {
            actionBar.setTitle(R.string.app_name);
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment, tag).commit();
    }

    private void showAnimalsFragment(int type) {
        AnimalsFragment fragment = (AnimalsFragment) getSupportFragmentManager().findFragmentByTag(AnimalsFragment.TAG);
        if (fragment != null && fragment.isVisible()) {
            fragment.getData(type);
        } else {
            fragment = new AnimalsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(AnimalsFragment.TYPE_ARGUMENT_KEY, type);
            fragment.setArguments(bundle);
            changeFragment(fragment, AnimalsFragment.TAG);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        drawer.addDrawerListener(drawerListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        drawer.removeDrawerListener(drawerListener);
    }

    private DrawerLayout.DrawerListener drawerListener = new DrawerLayout.SimpleDrawerListener() {
        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {
            super.onDrawerSlide(drawerView, slideOffset);
            getInputMethodManager().hideSoftInputFromWindow(drawerView.getWindowToken(), 0);
        }
    };

    private InputMethodManager getInputMethodManager() {
        if (inputMethodManager == null) {
            inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        }
        return inputMethodManager;
    }
}
