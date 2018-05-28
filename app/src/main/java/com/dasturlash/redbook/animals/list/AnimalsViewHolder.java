package com.dasturlash.redbook.animals.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.dasturlash.redbook.R;
import com.dasturlash.redbook.models.AnimalDbModel;

import java.util.List;

class AnimalsViewHolder extends RecyclerView.ViewHolder {
    private ImageView image;
    private TextView titleUzb;
    private TextView titleRus;
    private TextView titleEng;


    public AnimalsViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.item_image);
        titleUzb = itemView.findViewById(R.id.item_title_uz);
        titleRus = itemView.findViewById(R.id.item_title_ru);
        titleEng = itemView.findViewById(R.id.item_title_en);
    }

    public void populateModel(List<AnimalDbModel> model, final int position, final AnimalsListItemClickListener listener, View view) {
        titleUzb.setText(model.get(position).getUzbName());
        titleRus.setText(model.get(position).getRusName());
        titleEng.setText(model.get(position).getEngName());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(position);
            }
        });
    }
}
