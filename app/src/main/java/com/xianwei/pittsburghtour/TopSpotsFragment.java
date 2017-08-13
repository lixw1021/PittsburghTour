package com.xianwei.pittsburghtour;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
        places.add(new Place(R.drawable.cmunatural,
                4.5f,
                "Carnegie Museum of Natural History",
                "Exhibition on bones, gems and ecosystem",
                "4400 Forbes Ave, Pittsburgh, PA 15213, USA",
                "Mon - Fri : 9 am -5 pm \nSat - Sun: 9 am - 8 pm",
                "+1 412-622-3131",
                "http://cmoa.org/",
                "The museum consists of 115,000 square feet (10,700 m2) organized into 20 galleries as well as research, library, and office space. It holds some 22 million specimens, of which about 10,000 are on view at any given time and about 1 million are cataloged in online databases. In 2008 it hosted 386,300 admissions and 63,000 school group visits. Museum education staff also actively engage in outreach by traveling to schools all around western Pennsylvania."));

        places.add(new Place(R.drawable.cmunatural,
                4.0f,
                "Carnegie Museum",
                "Exhibition on bones, gems and ecosystem",
                "4400 Forbes Ave, Pittsburgh, PA 15213, USA",
                "Mon - Fri : 9 am -5 pm \nSat - Sun: 9 am - 8 pm",
                "+1 321-622-3131",
                "http://cmoa.org/",
                "The museum consists of 115,000 square feet (10,700 m2) organized into 20 galleries as well as research, library, and office space. It holds some 22 million specimens, of which about 10,000 are on view at any given time and about 1 million are cataloged in online databases. In 2008 it hosted 386,300 admissions and 63,000 school group visits. Museum education staff also actively engage in outreach by traveling to schools all around western Pennsylvania."));

        places.add(new Place(R.drawable.cmunatural,
                4.0f,
                "Carnegie Museum",
                "Exhibition on bones, gems and ecosystem",
                "4400 Forbes Ave, Pittsburgh, PA 15213, USA",
                "Mon - Fri : 9 am -5 pm \nSat - Sun: 9 am - 8 pm",
                "+1 321-622-3131",
                "http://cmoa.org/",
                "The museum consists of 115,000 square feet (10,700 m2) organized into 20 galleries as well as research, library, and office space. It holds some 22 million specimens, of which about 10,000 are on view at any given time and about 1 million are cataloged in online databases. In 2008 it hosted 386,300 admissions and 63,000 school group visits. Museum education staff also actively engage in outreach by traveling to schools all around western Pennsylvania."));

        places.add(new Place(R.drawable.cmunatural,
                4.0f,
                "Carnegie Museum",
                "Exhibition on bones, gems and ecosystem",
                "4400 Forbes Ave, Pittsburgh, PA 15213, USA",
                "Mon - Fri : 9 am -5 pm \nSat - Sun: 9 am - 8 pm",
                "+1 321-622-3131",
                "http://cmoa.org/",
                "The museum consists of 115,000 square feet (10,700 m2) organized into 20 galleries as well as research, library, and office space. It holds some 22 million specimens, of which about 10,000 are on view at any given time and about 1 million are cataloged in online databases. In 2008 it hosted 386,300 admissions and 63,000 school group visits. Museum education staff also actively engage in outreach by traveling to schools all around western Pennsylvania."));

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
        intent.putExtra("OpenTime", currentPlace.getOpenTime());
        intent.putExtra("Phone", currentPlace.getPhone());
        intent.putExtra("Website", currentPlace.getWebsite());
        intent.putExtra("Description", currentPlace.getDescription());
        startActivity(intent);
    }
}
