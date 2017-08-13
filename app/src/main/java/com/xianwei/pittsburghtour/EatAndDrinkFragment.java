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

    PlaceAdapter placePlaceAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_list_root, container, false);
        ButterKnife.bind(this, rootView);

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.drawable.restaurant_altius,
                5.0f,
                "Altius",
                "New American dishes & craft cocktails",
                "1230 Grandview Ave, Pittsburgh, PA 15211",
                "+1 412-904-4442",
                "http://altiusrestaurantpittsburgh.com"));

        places.add(new Place(R.drawable.restaurant_lemont,
                5.0f,
                "LeMont Restaurant",
                "Upscale eatery & event space offers Continental fare, city views, banquets & a live music lounge",
                "1114 Grandview Ave, Pittsburgh, PA 15211",
                "+1 412-431-3100",
                "http://lemontpittsburgh.com"));

        places.add(new Place(R.drawable.restaurant_church,
                4.5f,
                "The Church Brew Works",
                "Former church is now a lofty space for house-brewed beers, plus a mix of pizza, pierogi & bratwurst",
                "3525 Liberty Ave, Pittsburgh, PA 15201",
                "+1 412-688-8200",
                "http://churchbrew.com"));

        places.add(new Place(R.drawable.restaurant_point,
                4.5f,
                "Point Brugge Cafe",
                "Cozy European-style bistro with indoor & outdoor seating offers Belgian-inspired dishes & brunch",
                "401 Hastings St, Pittsburgh, PA 15206",
                "+1 412-441-3334",
                "http://pointbrugge.com"));

        places.add(new Place(R.drawable.restaurant_sichuan,
                4.5f,
                "Sichuan Gourmet",
                "Casual Chinese eatery offering a menu of staples plus many spicy Sichuan dishes in a bright space",
                "1900 Murray Ave, Pittsburgh, PA 15217",
                "+1 412-521-1313",
                "http://sichuangourmetpa.com"));

        places.add(new Place(R.drawable.restaurant_everyday,
                4.5f,
                "Everyday Noodles",
                "A casual Chinese eatery specializing in noodle dishes that's known for its kitchen viewing window",
                "5875 Forbes Ave, Pittsburgh, PA 15217",
                "+1 412-421-6668",
                "http://everydaynoodlespgh.com"));

        placePlaceAdapter = new PlaceAdapter(getActivity(), places);
        listView.setAdapter(placePlaceAdapter);

        return rootView;
    }

    @OnItemClick(R2.id.list_root)
    void onItemClick(int position) {
        Place currentPlace = placePlaceAdapter.getItem(position);
        Intent intent = new Intent(getActivity(),PlaceActivity.class);
        intent.putExtra("ImageResourceId", currentPlace.getImageResourceId());
        intent.putExtra("Title", currentPlace.getTitle());
        intent.putExtra("Location", currentPlace.getLocation());
        intent.putExtra("Phone", currentPlace.getPhone());
        intent.putExtra("Website", currentPlace.getWebsite());
        startActivity(intent);
    }
}
