package com.dasturlash.redbook.favorites.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dasturlash.redbook.R;
import com.dasturlash.redbook.models.AnimalDbModel;

import java.util.List;

public class FavoriteListAdapter extends RecyclerView.Adapter<FavoriteListViewHolder> {
    private List<AnimalDbModel> models;
    private FavoriteListItemListener listItemClickListener;
    private View view;

    public FavoriteListAdapter(FavoriteListItemListener listItemClickListener) {
        this.listItemClickListener = listItemClickListener;
    }

    public void updateModel(List<AnimalDbModel> models) {
        this.models = models;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FavoriteListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animals, parent, false);
        return new FavoriteListViewHolder(view, listItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteListViewHolder holder, int position) {
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
