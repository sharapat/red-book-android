package com.dasturlash.redbook.animals;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.dasturlash.redbook.MainActivity;
import com.dasturlash.redbook.R;
import com.dasturlash.redbook.animals.list.AnimalsListAdapter;
import com.dasturlash.redbook.animals.list.AnimalsListItemClickListener;
import com.dasturlash.redbook.details.AnimalDetailActivity;
import com.dasturlash.redbook.models.AnimalDbModel;
import com.dasturlash.redbook.room.AnimalDatabase;

import java.util.List;
import java.util.Objects;

public class AnimalsFragment extends Fragment implements AnimalsListItemClickListener, AnimalsView {
    public static final String TAG = "animalsFragment";
    public static final String TYPE_ARGUMENT_KEY = "type";

    private AnimalsListAdapter adapter;
    private RecyclerView.LayoutManager manager;
    private AnimalsPresenter animalsPresenter;
    private View view;
    private RecyclerView animalsList;
    private TextView notFoundText;
    private String searchText;
    private int type;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new AnimalsListAdapter(this);
        manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        animalsPresenter = new AnimalsPresenter(this, AnimalDatabase.getAnimalDatabase(getActivity()).animalDao());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_animals, container, false);
        notFoundText = view.findViewById(R.id.not_found_message);
        animalsList = view.findViewById(R.id.list_animals);
        animalsList.setAdapter(adapter);
        animalsList.setLayoutManager(manager);
        animalsList.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        Bundle bundle = this.getArguments();
        int type;
        if (bundle != null) {
            type = bundle.getInt(TYPE_ARGUMENT_KEY);
        } else {
            type = MainActivity.INVERTEBRATES;
        }
        this.type = type;
        getData(type);
        return view;
    }

    @Override
    public void onItemClick(int id) {
        Intent intent = new Intent(getActivity(), AnimalDetailActivity.class);
        intent.putExtra(AnimalDetailActivity.ANIMAL_ID, id);
        startActivity(intent);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Activity.INPUT_METHOD_SERVICE);
        assert inputMethodManager != null;
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void searchAnimalsByName(String name) {
        searchText = name;
        animalsPresenter.searchAnimalsByName(name);
    }

    @Override
    public void updateAdapter(List<AnimalDbModel> models) {
        adapter.updateModel(models);
    }

    @Override
    public void hideAnimalsList() {
        animalsList.setVisibility(View.GONE);
    }

    @Override
    public void showAnimalsList() {
        animalsList.setVisibility(View.VISIBLE);
    }

    @Override
    public void showAnimalsNotFoundMessage() {
        String message = String.format("\"%s\" %s", searchText, getString(R.string.not_found_message));
        notFoundText.setText(message);
        notFoundText.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideAnimalsNotFoundMessage() {
        notFoundText.setVisibility(View.GONE);
    }

    public void getData(int type) {
        animalsPresenter.getData(type);
    }

    public int getType() {
        return type;
    }
}
