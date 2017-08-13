package com.xianwei.pittsburghtour;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by xianwei li on 8/12/2017.
 */

public class MainActivityAdapter extends FragmentPagerAdapter {

    private String tableTitles[] = new String[] {"Top Spots", "Eat&Drink", "Museum", "Park"};
    public MainActivityAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TopSpotsFragment();
            case 1:
                return new ParkFragment();
            case 2:
                return new MuseumFragment();
            case 3:
                return new EatAndDrinkFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tableTitles[position];
    }
}
