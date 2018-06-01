package com.dasturlash.redbook.favorites.list;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dasturlash.redbook.R;
import com.dasturlash.redbook.models.AnimalDbModel;

public class FavoriteListViewHolder extends RecyclerView.ViewHolder {
    private FavoriteListItemListener listener;
    private ConstraintLayout constraintLayout;
    private ImageView image;
    private TextView titleUzb;
    private TextView titleRus;
    private TextView titleEng;

    FavoriteListViewHolder(View itemView, FavoriteListItemListener listener) {
        super(itemView);
        this.listener = listener;
        titleUzb = itemView.findViewById(R.id.item_title_uz);
        titleEng = itemView.findViewById(R.id.item_title_en);
        titleRus = itemView.findViewById(R.id.item_title_ru);
        image = itemView.findViewById(R.id.item_image);
        constraintLayout = itemView.findViewById(R.id.item_animals_container);
    }

    public void populateModel(final AnimalDbModel model) {
        Context context = image.getContext();
        Integer resId = model.getId();
        String resName = "picture" + resId.toString();
        int imageId = context.getResources().getIdentifier(resName, "drawable", context.getPackageName());
        Glide.with(context)
                .load(imageId)
                .into(image);
        titleUzb.setText(model.getName_uz());
        titleRus.setText(model.getName_rus());
        titleEng.setText(model.getName_eng());
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(model.getId());
                listener.hideKeyboard();
            }
        });
    }
}
