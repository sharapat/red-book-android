package com.dasturlash.redbook.animals;

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

import com.dasturlash.redbook.MainActivity;
import com.dasturlash.redbook.R;
import com.dasturlash.redbook.animals.list.AnimalsListAdapter;
import com.dasturlash.redbook.animals.list.AnimalsListItemClickListener;
import com.dasturlash.redbook.models.AnimalDbModel;
import com.dasturlash.redbook.room.AnimalDatabase;

import java.util.List;

public class AnimalsFragment extends Fragment implements AnimalsListItemClickListener, AnimalsView {
    public static final String TAG = "animalsFragment";

    private AnimalsListAdapter adapter;
    private RecyclerView.LayoutManager manager;
    private AnimalsPresenter animalsPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new AnimalsListAdapter(this);
        manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        animalsPresenter = new AnimalsPresenter(AnimalDatabase.getAnimalDatabase(getActivity()).animalDao(), this, MainActivity.INVERTEBRATES);
        animalsPresenter.getData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animals, container, false);
        RecyclerView animalsList = view.findViewById(R.id.list_animals);
        animalsList.setAdapter(adapter);
        animalsList.setLayoutManager(manager);
        animalsList.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        return view;
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void updateAdapter(List<AnimalDbModel> models) {
        adapter.updateModel(models);
    }
}