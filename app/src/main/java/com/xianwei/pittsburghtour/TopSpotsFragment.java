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
        places.add(new Place(R.drawable.top_duquesne,
                5.0f,
                "The Society for the Preservation of the Duquesne Heights Incline",
                "A great spot to see the downtown pittsburgh",
                "1220 Grandview Ave, Pittsburgh, PA 15211",
                "Mon - Fri : 5:30 am -12:45 am \nSat - Sun: 7 am - 12:45 am",
                "+1 412-381-1665",
                "http://www.duquesneincline.org/",
                "Take a step back in time on a century-old cable car and see the best views of downtown Pittsburgh while riding one of the few remaining inclines in the country. Opened on May 20, 1877, the Duquesne Incline was rescued and restored by a group of local residents in 1963 and still delights residents and visitors with its original, elegant, wooden cable cars.  Now you can visit the interior of the incline and watch the machinery while it operates.  The Duquesne Incline's upper station houses a museum of Pittsburgh history, including photos and a storehouse of information on inclines from around the world. Unusual Pittsburgh souvenirs, maps and photos can be found at the gift shop"));

        places.add(new Place(R.drawable.museum_cmu_natural,
                4.0f,
                "Carnegie Museum of Natural History",
                "Landmark museum featuring exhibits on dinosaur bones, geology & the impact of humans on ecosystems",
                "4400 Forbes Ave, Pittsburgh, PA 15213",
                "Mon - Sat : 10 am -5 pm \nSun: 12  - 5 pm",
                "+1 412-622-3131",
                "http://www.carnegiemnh.org/",
                "The museum consists of 115,000 square feet (10,700 m2) organized into 20 galleries as well as research, library, and office space. It holds some 22 million specimens, of which about 10,000 are on view at any given time and about 1 million are cataloged in online databases. In 2008 it hosted 386,300 admissions and 63,000 school group visits. Museum education staff also actively engage in outreach by traveling to schools all around western Pennsylvania."));

        places.add(new Place(R.drawable.top_cathedral,
                5.0f,
                "Cathedral of Learning",
                "Cathedral of Learning is the landmark of University of Pittsburgh",
                "4200 Fifth Ave, Pittsburgh, PA 15260",
                "24 Hours",
                "+1 412-624-4141",
                "http://www.tour.pitt.edu/tour/cathedral-learning",
                "The Gothic Revival skyscraper that Pitt Chancellor John G. Bowman commissioned in 1921 inspired local industries to donate steel, cement, elevators, glass, plumbing, and heating elements. Thousands of adults today still have the certificates they received as school children upon contributing 10 cents to “’buy a brick” for the Cathedral.\n" +
                        "\n" +
                        "In addition to its magnificent four-story Commons Room at ground level, the 42-story Cathedral houses classrooms (including the internationally renowned Nationality Classrooms) academic and administrative offices, libraries, computer labs, a theater, a print shop, and a food court.\n" +
                        "\n" +
                        "In 2007, on the 70th anniversary of the Cathedral’s dedication, Pitt trustees approved a project to clean and restore the iconic building. Its interior has since been upgraded and its limestone exterior scrubbed of industrial grime.\n" +
                        "\n" +
                        "A landmark listed in the National Register of Historic Places, the 535-foot-tall Cathedral is the second-tallest educational building in the world after the University of Moscow’s main building. In recent years, families of peregrine falcons have nested atop the Cathedral."));

        places.add(new Place(R.drawable.top_national_roon,
                5.0f,
                "Nationality Rooms at the Cathedral of Learning",
                "The Nationality Rooms are a collection of 30 classrooms in the University of Pittsburgh's Cathedral of Learning depicting and donated by the national and ethnic groups that helped build the city of Pittsburgh",
                "4200 Fifth Ave, Pittsburgh, PA 15260",
                "Mon - Sat : 9 am - 4 pm \nSun: 11 am - 4 pm",
                "+1 412-624-6000",
                "http://www.nationalityrooms.pitt.edu/",
                "The Nationality Rooms are located on the first and third floors of the University of Pittsburgh's Cathedral of Learning. The rooms were designed to represent the culture of various ethnic groups that settled in Allegheny County and are supported by these cultural groups and governments. Tours are conducted year round. The public is invited to experience their ethnic identity and ancestral roots. The rooms are also in use as University classrooms."));

        places.add(new Place(R.drawable.top_garden,
                5.0f,
                "Phipps Conservatory and Botanical Gardens",
                "Schenley Park's horticulture hub features botanical gardens & a steel-&-glass Victorian greenhouse",
                "1 Schenley Drive, Pittsburgh, PA 15213",
                "Mon - Th : 9:30 am - 5 pm \nFri: 9:30 am - 10 pm \nSat - Sun: 9:30 am - 5 pm",
                "+1 412-622-6914",
                "https://www.phipps.conservatory.org/",
                "A green oasis in the middle of Pittsburgh’s vibrant Oakland neighborhood, Phipps has provided a world-class garden experience to its visitors since 1893. Visit to discover breathtaking seasonal flower shows, stunning outdoor botanical gardens, free-with-admission activities for all ages, an award-winning on-site café, and some of the greenest buildings in the world"));

        places.add(new Place(R.drawable.top_zoo,
                5.0f,
                "Pittsburgh Zoo & PPG Aquarium",
                "Animal center features an African Savanna, Asian Forest, Bear park, PPG Aquarium & Kids Kingdom",
                "7340 Butler St, Pittsburgh, PA 15206",
                "Mon - Sun : 9:30 am - 6 pm",
                "+1 412-655-3640",
                "http://www.pittsburghzoo.org/",
                "More than a century ago, philanthropist Christopher Lyman Magee donated $125,000 for the construction of a zoological garden in Pittsburgh's Highland Park neighborhood. On June 14, 1898, the Pittsburgh Zoo opened its gates to the public, providing visitors with a rare glimpse of animals and plants they had never seen before. Fitting in with the paradigm of the day, the Zoo resembled more of an animal menagerie than it does today. Through the years, however, the Zoo has transformed itself, incorporating naturalistic habitats for a great variety of species, as well as becoming a resource for conservation, education, and research.\n" + "This evolution began in 1937 with the addition of outdoor bear exhibits. In 1949, Pittsburgh's first Children's Zoo opened--thanks to a generous grant from the Sarah Mellon Scaife Foundation. In the 40 years that followed, children delighted in the charming and imaginative exhibits--like walking into the mouth of whale with its soft spongy tongue, and the giant hunk of cheese that was home to dozens of mice. When the AquaZoo opened in 1967, it was the only public aquarium in Pennsylvania and the second largest aquarium in the country at the time.\n"));

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
