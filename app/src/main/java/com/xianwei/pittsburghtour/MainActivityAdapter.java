package com.xianwei.pittsburghtour;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by xianwei li on 8/12/2017.
 */

 class MainActivityAdapter extends FragmentPagerAdapter {

    private String[] tableTitles;
     MainActivityAdapter(FragmentManager fm, Context context) {
        super(fm);
        tableTitles = context.getResources().getStringArray(R.array.table_title);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TopSpotsFragment();
            case 1:
                return new MuseumFragment();
            case 2:
                return new ParkFragment();
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
