package com.dasturlash.redbook.favorites;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dasturlash.redbook.R;
import com.dasturlash.redbook.details.AnimalDetailActivity;
import com.dasturlash.redbook.favorites.list.FavoriteListAdapter;
import com.dasturlash.redbook.favorites.list.FavoriteListItemListener;
import com.dasturlash.redbook.models.AnimalDbModel;
import com.dasturlash.redbook.room.AnimalDatabase;

import java.util.List;
import java.util.Objects;

public class FavoritesFragment extends Fragment implements FavoriteListItemListener, FavoritesView {
    public static final String TAG = "favoriteFragment";

    private FavoritePresenter presenter;
    private RecyclerView favoritesList;
    private FavoriteListAdapter adapter;
    private RecyclerView.LayoutManager manager;
    private TextView emptyText;
    private TextView notFoundText;
    private String searchText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new FavoriteListAdapter(this);
        manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        presenter = new FavoritePresenter(AnimalDatabase.getAnimalDatabase(getActivity()).animalDao(), this);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        emptyText = view.findViewById(R.id.empty_favorites);
        notFoundText = view.findViewById(R.id.not_found_message);
        favoritesList = view.findViewById(R.id.list_favorites);
        favoritesList.setAdapter(adapter);
        favoritesList.setLayoutManager(manager);
        favoritesList.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL));
        getFavorites();
        return view;
    }

    @Override
    public void updateAdapter(List<AnimalDbModel> models) {
        adapter.updateModel(models);
    }

    @Override
    public void showEmptyMessage() {
        emptyText.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmptyMessage() {
        emptyText.setVisibility(View.GONE);
    }

    @Override
    public void showNotFoundMessage() {
        String message = String.format("\"%s\" %s", searchText, getString(R.string.not_found_message));
        notFoundText.setText(message);
        notFoundText.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideNotFoundMessage() {
        notFoundText.setVisibility(View.GONE);
    }

    @Override
    public void showFavoritesList() {
        favoritesList.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideFavoritesList() {
        favoritesList.setVisibility(View.GONE);
    }

    @Override
    public void onItemClick(int id) {
        Intent intent = new Intent(getActivity(), AnimalDetailActivity.class);
        intent.putExtra(AnimalDetailActivity.ANIMAL_ID, id);
        intent.putExtra(AnimalDetailActivity.FROM_FAVORITE, true);
        startActivity(intent);
    }

    public void getFavorites() {
        presenter.getFavorites();
    }

    public void searchFavoritesByName(String name) {
        searchText = name;
        presenter.searchFavoritesByName(name);
    }
}
