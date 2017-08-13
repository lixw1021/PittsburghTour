package com.xianwei.pittsburghtour;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xianwei li on 8/11/2017.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    public PlaceAdapter(@NonNull Context context, @NonNull List<Place> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Place place = getItem(position);
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        holder.imageView.setImageResource(place.getImageResourceId());
        holder.title.setText(place.getTitle());
        holder.ratingBar.setRating(place.getRating());
        holder.introduction.setText(place.getIntroduction());

        return convertView;
    }

    static class ViewHolder {
        @BindView(R2.id.item_image_view)
        ImageView imageView;
        @BindView(R2.id.item_title_text_view)
        TextView title;
        @BindView(R2.id.item_rating_bar)
        RatingBar ratingBar;
        @BindView(R2.id.item_summary_text_view)
        TextView introduction;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
