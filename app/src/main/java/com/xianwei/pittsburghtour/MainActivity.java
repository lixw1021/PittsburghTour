package com.xianwei.pittsburghtour;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {
    MainActivityAdapter mainActivityAdapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainActivityAdapter = new MainActivityAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(mainActivityAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }


}
