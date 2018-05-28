package com.dasturlash.redbook.animals.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dasturlash.redbook.R;
import com.dasturlash.redbook.models.AnimalDbModel;

import java.util.List;

public class AnimalsListAdapter extends RecyclerView.Adapter<AnimalsViewHolder> {
    private List<AnimalDbModel> models;
    private AnimalsListItemClickListener listItemClickListener;
    private View view;

    public AnimalsListAdapter(AnimalsListItemClickListener listItemClickListener) {
        this.listItemClickListener = listItemClickListener;
    }

    public void updateModel(List<AnimalDbModel> models) {
        this.models = models;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AnimalsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animals, parent, false);
        return new AnimalsViewHolder(view, listItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalsViewHolder holder, int position) {
        AnimalDbModel item = models.get(position);
        if (item != null) {
            holder.populateModel(item);
        }
    }

    @Override
    public int getItemCount() {
        return models == null ? 0 : models.size();
    }
}
