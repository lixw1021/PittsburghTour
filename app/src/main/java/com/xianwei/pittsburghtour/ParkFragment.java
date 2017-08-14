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

public class ParkFragment extends Fragment {
    @BindView(R2.id.list_root)
    ListView listView;

    private PlaceAdapter placePlaceAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_list_root, container, false);
        ButterKnife.bind(this, rootView);
        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.drawable.park_westend,
                5.0f,
                getString(R.string.park_westend_title),
                getString(R.string.park_westend_introduction),
                getString(R.string.park_westend_location),
                getString(R.string.park_westend_open_time),
                getString(R.string.park_westend_phone),
                getString(R.string.park_westend_website),
                getString(R.string.park_westend_description)));

        places.add(new Place(R.drawable.park_emerala,
                5.0f,
                getString(R.string.park_emerala_title),
                getString(R.string.park_emerala_introduction),
                getString(R.string.park_emerala_location),
                getString(R.string.park_emerala_open_time),
                getString(R.string.park_emerala_phone),
                getString(R.string.park_emerala_website),
                getString(R.string.park_emerala_descrpition)));

        places.add(new Place(R.drawable.park_schenley,
                4.5f,
                getString(R.string.park_schenley_title),
                getString(R.string.park_schenley_introduction),
                getString(R.string.park_schenley_location),
                getString(R.string.park_schenley_open_time),
                getString(R.string.park_schenley_phone),
                getString(R.string.park_schenley_website),
                getString(R.string.park_schenley_description)));

        places.add(new Place(R.drawable.park_frick,
                4.5f,
                getString(R.string.park_frick_title),
                getString(R.string.park_frick_introduction),
                getString(R.string.park_frick_location),
                getString(R.string.park_frick_open_time),
                getString(R.string.park_frick_phone),
                getString(R.string.park_frick_website),
                getString(R.string.park_frick_description)));

        places.add(new Place(R.drawable.park_point_state,
                4.0f,
                getString(R.string.park_point_state_title),
                getString(R.string.park_point_state_introduction),
                getString(R.string.park_point_state_location),
                getString(R.string.park_point_state_open_time),
                getString(R.string.park_point_state_phone),
                getString(R.string.park_point_state_website),
                getString(R.string.park_point_state_description)));

        places.add(new Place(R.drawable.park_highland,
                4.0f,
                getString(R.string.park_highland_title),
                getString(R.string.park_highland_introduction),
                getString(R.string.park_highland_location),
                getString(R.string.park_highland_open_time),
                getString(R.string.park_highland_phone),
                getString(R.string.park_highland_website),
                getString(R.string.park_highland_description)));

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
