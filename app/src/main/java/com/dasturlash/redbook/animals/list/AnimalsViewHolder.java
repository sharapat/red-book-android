package com.dasturlash.redbook.animals.list;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.dasturlash.redbook.R;
import com.dasturlash.redbook.models.AnimalDbModel;

class AnimalsViewHolder extends RecyclerView.ViewHolder {
    private ImageView image;
    private TextView titleUzb;
    private TextView titleRus;
    private TextView titleEng;
    private AnimalsListItemClickListener listener;
    private ConstraintLayout constraintLayout;

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
        Glide.with(context)
                .load(imageId)
                .centerCrop()
                .into(image);
        titleUzb.setText(model.getNameUzb());
        titleRus.setText(model.getNameRus());
        titleEng.setText(model.getNameEng());

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(model.getId());
                listener.hideKeyboard();
            }
        });
    }
}
