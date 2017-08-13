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

    PlaceAdapter placePlaceAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_list_root, container, false);
        ButterKnife.bind(this, rootView);
        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.drawable.park_westend,
                5.0f,
                "West End-Elliott Overlook Park",
                "This park by the Ohio River offers city views & is a popular spot for summer movies & fireworks",
                "Marlow St, Pittsburgh, PA 15205",
                "24 Hours",
                "+1 412-255-2539",
                "http://pittsburghpa.gov/citiparks/cinema-overlook",
                "This park by the Ohio River offers city views & is a popular spot for summer movies & fireworks"));

        places.add(new Place(R.drawable.park_emerala,
                5.0f,
                "Emerald View Park",
                "It encircles the neighborhoods of Mt. Washington, Duquesne Heights and Allentown and offers scenic views of the city that draw more than 1 million visitors annually",
                "Bailey Ave, Pittsburgh, PA 15211",
                "Mon - Sun: 6 am - 11 pm",
                "+1 412-255-2539",
                "http://mwcdc.org/park/",
                "Emerald View Park surrounds the neighborhoods of Duquesne Heights, Mount Washington and Allentown. The urban park that combines pre-existing park space with formerly mined and denuded hillsides was born out of a grassroots effort to protect Mount Washington’s steep hillsides and improve the quality of local park land."));

        places.add(new Place(R.drawable.park_schenley,
                4.5f,
                "Schenley Park",
                "Park has 456 acres of trails, a sportsplex, botanical gardens, cafe, visitors center & golf course",
                "1 Overlook Dr, Pittsburgh, PA 15238",
                "Mon - Sun: 6 am - 11 pm",
                "+1 412-682-7275",
                "https://www.pittsburghparks.org/schenley-park",
                "Created in 1889 with land donated by heiress Mary Schenley, the park now contains 456 acres of trails, woods, and attractions. A daily destination for university students, business-people, and outdoor enthusiasts, the park also hosts major annual events such as the Vintage Grand Prix and the Pittsburgh Race for the Cure.\n" + "Visitors to Schenley Park can spend a morning at the remarkable Phipps Conservatory, enjoy lunch and a concert at the Schenley Park Café and Visitor Center, relax on Flagstaff Hill, play a round at the Bob O’Connor Golf Course, head to the Schenley Oval Sportsplex for ice skating or summer sports, or take a dip in the swimming pool. And of course, the trails offer a refreshing and convenient escape from the city"));

        places.add(new Place(R.drawable.park_frick,
                4.5f,
                "Frick Park",
                "Lush city park featuring grassy picnic areas, off-leash dog play spots & wetlands",
                "1981 Beechwood Blvd, Pittsburgh, PA 15217",
                "Mon - Sun: 6 am - 11 pm",
                "+1 412-682-7275",
                "https://www.pittsburghparks.org/frick-park",
                "Although Henry Clay Frick bequeathed the original 151 acres to the city in 1919, the park did not open until 1927 after additional land had been acquired. Most recently, 106 acres were annexed to the park as part of the process that created the Summerset at Frick Park housing development and restored the Nine Mile Run stream valley. Today, Frick Park stretches from its northern borders in Point Breeze down to the Monongahela River."));

        places.add(new Place(R.drawable.park_point_state,
                4.0f,
                "Point State Park",
                "A 36-acre park at the intersection of 3 rivers has boating, hiking, biking & a Fort Pitt museum",
                "601 Commonwealth Pl, Pittsburgh, PA 15222",
                "24 Hours",
                "+1 412-565-2850",
                "http://www.dcnr.state.pa.us/stateparks/findapark/point/",
                "Point State Park, located at the confluence of three rivers, is at the tip of Pittsburgh’s “Golden Triangle.” The park commemorates and preserves the strategic and historic heritage of the area during the French and Indian War (1754 - 1763).\n" + "Once a busy industrial zone, the area had deteriorated into a commercial slum by the 1940s. The development of a state park was authorized in 1945 and the first parcel of the 36-acre property was purchased the next year. The park was completed and dedicated in 1974. In 1975, Point State Park was designated a National Historic Landmark."));

        places.add(new Place(R.drawable.park_highland,
                4.0f,
                "Highland Park Entry Garden",
                "Pittsburgh's need for a municipal water system brought about the creation of Highland Park in the late 1800",
                "1467 N Highland Ave, Pittsburgh, PA 15206",
                "24 Hours",
                "+1 412-628-7275",
                "https://www.pittsburghparks.org/highland-park",
                "By 1879, a reservoir that provided drinking water for the city was opened in an area surrounded by public land and greenery. People were naturally drawn to the site for its open space and scenic beauty, and the increasing popularity of the reservoir for picnics and passive recreation caught the attention of the Parks Commission. Twenty years later, the city made it official, establishing Highland Park by ordinance. Today, Reservoir No. 1 remains an iconic feature of Highland Park, and the Reservoir Loop is a favorite trail for walkers and joggers.\n" + "The reservoir is accessed through the beautiful Entry Garden, a Victorian-style gathering place with gardens, a fountain and reflecting pool, and benches for relaxing. Highland Park also features a popular bike track, swimming pool, sand volleyball courts, and the Pittsburgh Zoo and PPG Aquarium. A water filtration plant cleans the water from the main reservoir, and waste water is naturally de-chlorinated in part by a brook which trickles into Lake Carnegie."));

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
