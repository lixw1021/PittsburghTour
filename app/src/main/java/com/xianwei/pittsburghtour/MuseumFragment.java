package com.xianwei.pittsburghtour;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by xianwei li on 8/13/2017.
 */

public class MuseumFragment extends Fragment {
    @BindView(R2.id.list_root)
    ListView listView;

    private PlaceAdapter placePlaceAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_list_root, container, false);
        ButterKnife.bind(this, rootView);
        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.drawable.museum_cmu_natural,
                5.0f,
                getString(R.string.top_spots_carnegie_museum_of_natural_history_title),
                getString(R.string.top_spots_carnegie_museum_of_natural_history_introduction),
                getString(R.string.top_spots_carnegie_museum_of_natural_history_location),
                getString(R.string.top_spots_carnegie_museum_of_natural_history_open_time),
                getString(R.string.top_spots_carnegie_museum_of_natural_history_phone),
                getString(R.string.top_spots_carnegie_museum_of_natural_history_website),
                getString(R.string.top_spots_carnegie_museum_of_natural_history_description)));

        places.add(new Place(R.drawable.museum_cmu_art,
                5.0f,
                getString(R.string.museum_cm_art_title),
                getString(R.string.museum_cm_art_introduction),
                getString(R.string.museum_cm_art_location),
                getString(R.string.museum_cm_art_open_time),
                getString(R.string.museum_cm_art_phone),
                getString(R.string.museum_cm_art_website),
                getString(R.string.museum_cm_art_description)));

        places.add(new Place(R.drawable.museum_heinz_history,
                4.5f,
                getString(R.string.museum_heinz_history_title),
                getString(R.string.museum_heinz_history_introduction),
                getString(R.string.museum_heinz_history_location),
                getString(R.string.museum_heinz_history_open_time),
                getString(R.string.museum_heinz_history_phone),
                getString(R.string.museum_heinz_history_website),
                getString(R.string.museum_heinz_history_description)));

        places.add(new Place(R.drawable.museum_bicycle,
                4.0f,
                getString(R.string.museum_bicycle_title),
                getString(R.string.museum_bicycle_introduction),
                getString(R.string.museum_bicycle_location),
                getString(R.string.museum_bicycle_open_time),
                getString(R.string.museum_bicycle_phone),
                getString(R.string.museum_bicycle_website),
                getString(R.string.museum_bicycle_description)));

        places.add(new Place(R.drawable.museum_carnegie_science,
                4.0f,
                getString(R.string.museum_carnegie_science_title),
                getString(R.string.museum_carnegie_science_introduction),
                getString(R.string.museum_carnegie_science_location),
                getString(R.string.museum_carnegie_science_open_time),
                getString(R.string.museum_carnegie_science_phone),
                getString(R.string.museum_carnegie_science_website),
                getString(R.string.museum_carnegie_science_description)));

        placePlaceAdapter = new PlaceAdapter(getActivity(), places);
        listView.setAdapter(placePlaceAdapter);

        return rootView;
    }

    @OnItemClick(R2.id.list_root)
    void onItemClick(int position) {
        Place currentPlace = placePlaceAdapter.getItem(position);
        Intent intent = new Intent(getActivity(), PlaceActivity.class);
        intent.putExtra("ImageResourceId", currentPlace.getImageResourceId());
        intent.putExtra("Title", currentPlace.getTitle());
        intent.putExtra("Location", currentPlace.getLocation());
        intent.putExtra("OpenTime", currentPlace.getOpenTime());
        intent.putExtra("Phone", currentPlace.getPhone());
        intent.putExtra("Website", currentPlace.getWebsite());
        intent.putExtra("Description", currentPlace.getDescription());
        startActivity(intent);
    }
}
