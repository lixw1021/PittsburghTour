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

    PlaceAdapter placePlaceAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_list_root, container, false);
        ButterKnife.bind(this, rootView);
        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.drawable.museum_cmu_natural,
                5.0f,
                "Carnegie Museum of Natural History",
                "Landmark museum featuring exhibits on dinosaur bones, geology & the impact of humans on ecosystems",
                "4400 Forbes Ave, Pittsburgh, PA 15213",
                "Mon - Wed : 10 am - 5 pm \nThu: 10: am - 8 pm \nFri - Sat: 10 am - 5 pm \nSun: 12 - 5 pm",
                "+1 412-622-3131",
                "http://cmoa.org/",
                "The museum consists of 115,000 square feet (10,700 m2) organized into 20 galleries as well as research, library, and office space. It holds some 22 million specimens, of which about 10,000 are on view at any given time and about 1 million are cataloged in online databases. In 2008 it hosted 386,300 admissions and 63,000 school group visits. Museum education staff also actively engage in outreach by traveling to schools all around western Pennsylvania."));

        places.add(new Place(R.drawable.museum_cmu_art,
                5.0f,
                "Carnegie Museum of Art",
                "Sprawling contemporary art museum features permanent collections of paintings, sculptures & more",
                "4400 Forbes Ave, Pittsburgh, PA 15213",
                "Mon - Wed : 10 am - 5 pm \nThu: 10: am - 8 pm \nFri - Sat: 10 am - 5 pm \nSun: 12 - 5 pm",
                "+1 412-622-3131",
                "http://cmoa.org/",
                "Carnegie Museum of Art is arguably the first museum of contemporary art in the United States, collecting the “Old Masters of tomorrow” since the inception of the Carnegie International in 1896. Today, the museum is one of the most dynamic major art institutions in America. Our collection of more than 30,000 objects features a broad spectrum of visual arts, including painting and sculpture; prints and drawings; photographs; architectural casts, renderings, and models; decorative arts and design; and film, video, and digital imagery. Through our programming, exhibitions, and publications, we frequently explore the role of art and artists in confronting key social issues of our time, combining and juxtaposing local and global perspectives. With our unique history and resources, we strive to become a leader in defining the role of art museums for the 21st century"));

        places.add(new Place(R.drawable.museum_heinz_history,
                5.0f,
                "Senator John Heinz History Center",
                "Smithsonian affiliate has 6 floors of historical exhibits, archives & a separate sports museum",
                "1212 Smallman St, Pittsburgh, PA 15222",
                "Mon - Sun: 10 am - 5 pm",
                "+1 412-454-6000",
                "http://heinzhistorycenter.org",
                "Devoted to the history and heritage of Western Pennsylvania, the History Center (legal name – the Historical Society of Western Pennsylvania) is Pennsylvania’s largest history museum and a proud affiliate of the Smithsonian Institution.\n" + "The Senator John Heinz History Center family of museums and programs includes the Heinz History Center, Western Pennsylvania Sports Museum, Fort Pitt Museum, Meadowcroft Rockshelter and Historic Village, Detre Library & Archives, and the new Museum Conservation Center. The 370,000 square-foot museum presents compelling stories from American history with a Western Pennsylvania connection in an interactive environment perfect for visitors of all ages"));

        places.add(new Place(R.drawable.museum_bicycle,
                5.0f,
                "Bicycle Heaven",
                "Doing repairs and selling used bikes and collecting vintage Antique and collectible bikes with over 3000 bikes scattered in garages through out the Bellevue area",
                "1800 Preble Ave, Pittsburgh, PA 15233",
                "Mon - Sun: 10 am - 7 pm",
                "+1 412-734-4034",
                "http://bicycleheaven.org",
                "Bicycle Heaven Museum was established in 2011 by Craig & Mindy Morrow.  It is the world's largest bicycle museum & shop, as seen in the New York Times and Associated Press.  Rated on Trip Advisor as the #1 Pittsburgh Museum and and voted top bike shop in Pittsburgh.   You can get your bike fixed, tuned up, or trade it in for a newer (or older) bicycle.  We also rent out bikes. You can see our bikes in movies such as: A Beautiful Mind, Super 8, Fathers & Daughters, Fences and many others.  On display in our museum is a Pee-wee Herman bike from the movie Pee-wee's Big Adventure!"));

        places.add(new Place(R.drawable.museum_carnegie_science,
                5.0f,
                "Carnegie Science Center",
                "Museum & research center offers science-related exhibits, a planetarium, live shows & kids programs",
                "1 Allegheny Ave, Pittsburgh, PA 15212",
                "Mon - Sun: 10 am - 5 pm",
                "+1 412-237-3400",
                "http://carnegiesciencecenter.org",
                "Recipient of the 2003 National Award for Museum Service, Carnegie Science Center inspires and entertains by connecting science and technology with everyday life. In addition to providing valuable scientific experiences, Carnegie Science Center engages in outreach programs that serve Pittsburgh's diverse community. The Science Center is located on Pittsburgh's North Shore along the banks of the Ohio River and is accessible to persons with disabilities."));

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
