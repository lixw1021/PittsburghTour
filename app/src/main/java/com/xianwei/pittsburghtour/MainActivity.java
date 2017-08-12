package com.xianwei.pittsburghtour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R2.id.list_root)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_root);
        ButterKnife.bind(this);

        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(R.drawable.cmunatural,
                            4.5f,
                            "Carnegie Museum of Natural History",
                            "Exhibition on bones, gems and ecosystem",
                            "4400 Forbes Ave, Pittsburgh, PA 15213, USA",
                            "Mon - Fri : 9 am -5 pm \nSat - Sun: 9 am - 8 pm",
                            "+1 412-622_3131",
                            "http://cmoa.org/",
                            "The museum consists of 115,000 square feet (10,700 m2) organized into 20 galleries as well as research, library, and office space. It holds some 22 million specimens, of which about 10,000 are on view at any given time and about 1 million are cataloged in online databases. In 2008 it hosted 386,300 admissions and 63,000 school group visits. Museum education staff also actively engage in outreach by traveling to schools all around western Pennsylvania."));

        places.add(new Place(R.drawable.cmunatural,
                            4.5f,
                            "Carnegie Museum of Natural History",
                            "Exhibition on bones, gems and ecosystem",
                            "4400 Forbes Ave, Pittsburgh, PA 15213, USA",
                            "Mon - Fri : 9 am -5 pm \nSat - Sun: 9 am - 8 pm",
                            "+1 412-622_3131",
                            "http://cmoa.org/",
                            "The museum consists of 115,000 square feet (10,700 m2) organized into 20 galleries as well as research, library, and office space. It holds some 22 million specimens, of which about 10,000 are on view at any given time and about 1 million are cataloged in online databases. In 2008 it hosted 386,300 admissions and 63,000 school group visits. Museum education staff also actively engage in outreach by traveling to schools all around western Pennsylvania."));

        PlaceAdapter placePlaceAdapter = new PlaceAdapter(this, places);
        listView.setAdapter(placePlaceAdapter);

    }
}
