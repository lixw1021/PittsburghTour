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
 * Created by xianwei li on 8/12/2017.
 */

public class TopSpotsFragment extends Fragment {
    @BindView(R2.id.list_root)
    ListView listView;

    PlaceAdapter placePlaceAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_list_root, container, false);
        ButterKnife.bind(this, rootView);
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(R.drawable.top_duquesne,
                5.0f,
                getString(R.string.top_spots_dequesne_title),
                getString(R.string.top_spots_dequesne_introduction),
                getString(R.string.top_spots_dequesne_location),
                getString(R.string.top_spots_dequesne_open_time),
                getString(R.string.top_spots_dequesne_phone),
                getString(R.string.top_spots_dequesne_website),
                getString(R.string.top_spots_dequesne_description)));

        places.add(new Place(R.drawable.museum_cmu_natural,
                4.0f,
                getString(R.string.top_spots_carnegie_museum_of_natural_history_title),
                getString(R.string.top_spots_carnegie_museum_of_natural_history_introduction),
                getString(R.string.top_spots_carnegie_museum_of_natural_history_location),
                getString(R.string.top_spots_carnegie_museum_of_natural_history_open_tome),
                getString(R.string.top_spots_carnegie_museum_of_natural_history_phone),
                getString(R.string.top_spots_carnegie_museum_of_natural_history_website),
                getString(R.string.top_spots_carnegie_museum_of_natural_history_description)));

        places.add(new Place(R.drawable.top_cathedral,
                5.0f,
                getString(R.string.top_spots_cathedral_learning_title),
                getString(R.string.top_spots_cathedral_learning_introduction),
                getString(R.string.top_spots_cathedral_learning_location),
                getString(R.string.top_spots_cathedral_learning_open_time),
                getString(R.string.top_spots_cathedral_learning_phone),
                getString(R.string.top_spots_cathedral_learning_website),
                getString(R.string.top_spots_cathedral_learning_description)));

        places.add(new Place(R.drawable.top_national_roon,
                5.0f,
                getString(R.string.top_spots_national_roon_title),
                getString(R.string.top_spots_national_roon_introduction),
                getString(R.string.top_spots_national_roon_location),
                getString(R.string.top_spots_national_roon_open_time),
                getString(R.string.top_spots_national_roon_phone),
                getString(R.string.top_spots_national_roon_website),
                getString(R.string.top_spots_national_roon_description)));

        places.add(new Place(R.drawable.top_garden,
                5.0f,
                getString(R.string.top_spots_garden_title),
                getString(R.string.top_spots_garden_introduction),
                getString(R.string.top_spots_garden_location),
                getString(R.string.top_spots_garden_open_time),
                getString(R.string.top_spots_garden_phone),
                getString(R.string.top_spots_garden_website),
                getString(R.string.top_spots_garden_description)));

        places.add(new Place(R.drawable.top_zoo,
                5.0f,
                getString(R.string.top_spots_zoo_title),
                getString(R.string.top_spots_zoo_introduction),
                getString(R.string.top_spots_zoo_location),
                getString(R.string.top_spots_zoo_open_time),
                getString(R.string.top_spots_zoo_phone),
                getString(R.string.top_spots_zoo_website),
                getString(R.string.top_spots_zoo_description)));

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
