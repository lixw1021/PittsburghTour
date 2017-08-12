package com.xianwei.pittsburghtour;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xianwei li on 8/11/2017.
 */

public class PlaceActivity extends AppCompatActivity {
    @BindView(R.id.place_image_view)
    ImageView imageView;
    @BindView(R.id.place_title_text_view)
    TextView title;
    @BindView(R.id.place_address_text_view)
    TextView address;
    @BindView(R.id.place_open_time_text_view)
    TextView openTime;
    @BindView(R.id.place_phone_text_view)
    TextView phone;
    @BindView(R.id.place_website_text_view)
    TextView website;
    @BindView(R.id.place_description)
    TextView description;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        ButterKnife.bind(this);
        setupUI(getIntent());
    }

    private void setupUI(Intent intent) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView.setImageResource(intent.getIntExtra("ImageResourceId", 0));
        title.setText(intent.getStringExtra("Title"));
        address.setText(intent.getStringExtra("Location"));
        openTime.setText(intent.getStringExtra("OpenTime"));
        phone.setText(intent.getStringExtra("Phone"));
        website.setText(intent.getStringExtra("Website"));
        description.setText(intent.getStringExtra("Description"));
    }
}
