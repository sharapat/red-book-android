package com.dasturlash.redbook.animals.list;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dasturlash.redbook.R;
import com.dasturlash.redbook.models.AnimalDbModel;

import java.util.List;

class AnimalsViewHolder extends RecyclerView.ViewHolder {
    private ImageView image;
    private TextView titleUzb;
    private TextView titleRus;
    private TextView titleEng;
    private AnimalsListItemClickListener listener;
    ConstraintLayout constraintLayout;

    AnimalsViewHolder(View itemView, AnimalsListItemClickListener listener) {
        super(itemView);
        this.listener = listener;
        constraintLayout = itemView.findViewById(R.id.item_animals_container);
        image = itemView.findViewById(R.id.item_image);
        titleUzb = itemView.findViewById(R.id.item_title_uz);
        titleRus = itemView.findViewById(R.id.item_title_ru);
        titleEng = itemView.findViewById(R.id.item_title_en);
    }

    public void populateModel(final AnimalDbModel model) {
        Context context = image.getContext();
        Integer resId = model.getId();
        String resName = "picture" + resId.toString();
        int imageId = context.getResources().getIdentifier(resName, "drawable", context.getPackageName());
        Log.d("imageId", imageId + "");
        image.setImageResource(imageId);
        titleUzb.setText(model.getName_uz());
        titleRus.setText(model.getName_rus());
        titleEng.setText(model.getName_eng());

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(model.getId());
            }
        });
    }
}
