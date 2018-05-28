package com.dasturlash.redbook.animals.list;

import android.content.Context;
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


    AnimalsViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.item_image);
        titleUzb = itemView.findViewById(R.id.item_title_uz);
        titleRus = itemView.findViewById(R.id.item_title_ru);
        titleEng = itemView.findViewById(R.id.item_title_en);
    }

    public void populateModel(List<AnimalDbModel> model, final int position, final AnimalsListItemClickListener listener, View view) {
        Context context = image.getContext();
        Integer resId = position + 1;
        String resName = "picture" + resId.toString() + ".png";
        int imageId = context.getResources().getIdentifier(resName, "drawable", context.getPackageName());
        Log.d("imageId", imageId + "");
        image.setImageResource(imageId);
        titleUzb.setText(model.get(position).getName_uz());
        titleRus.setText(model.get(position).getName_rus());
        titleEng.setText(model.get(position).getName_eng());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(position);
            }
        });
    }
}
