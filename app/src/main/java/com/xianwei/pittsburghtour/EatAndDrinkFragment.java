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

public class EatAndDrinkFragment extends Fragment {
    @BindView(R2.id.list_root)
    ListView listView;

    private PlaceAdapter placePlaceAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_list_root, container, false);
        ButterKnife.bind(this, rootView);

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.drawable.restaurant_altius,
                5.0f,
                getString(R.string.restaurant_altius_title),
                getString(R.string.restaurant_altius_introduction),
                getString(R.string.restaurant_altius_location),
                getString(R.string.restaurant_altius_phone),
                getString(R.string.restaurant_altius_website)));

        places.add(new Place(R.drawable.restaurant_lemont,
                5.0f,
                getString(R.string.restaurant_lemont_title),
                getString(R.string.restaurant_lemont_introduction),
                getString(R.string.restaurant_lemont_location),
                getString(R.string.restaurant_lemont_phone),
                getString(R.string.restaurant_lemont_website)));

        places.add(new Place(R.drawable.restaurant_church,
                4.5f,
                getString(R.string.restaurant_church_title),
                getString(R.string.restaurant_church_introduction),
                getString(R.string.restaurant_church_location),
                getString(R.string.restaurant_church_phone),
                getString(R.string.restaurant_church_website)));

        places.add(new Place(R.drawable.restaurant_point,
                4.5f,
                getString(R.string.restaurant_point_title),
                getString(R.string.restaurant_point_introduction),
                getString(R.string.restaurant_point_location),
                getString(R.string.restaurant_point_phone),
                getString(R.string.restaurant_point_website)));

        places.add(new Place(R.drawable.restaurant_sichuan,
                4.5f,
                getString(R.string.restaurant_sichuan_title),
                getString(R.string.restaurant_sichuan_introduction),
                getString(R.string.restaurant_sichuan_location),
                getString(R.string.restaurant_sichuan_phone),
                getString(R.string.restaurant_sichuan_website)));

        places.add(new Place(R.drawable.restaurant_everyday,
                4.5f,
                getString(R.string.restaurant_everyday_title),
                getString(R.string.restaurant_everyday_introduction),
                getString(R.string.restaurant_everyday_location),
                getString(R.string.restaurant_everyday_phone),
                getString(R.string.restaurant_everyday_website)));

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
        intent.putExtra("Phone", currentPlace.getPhone());
        intent.putExtra("Website", currentPlace.getWebsite());
        startActivity(intent);
    }
}
