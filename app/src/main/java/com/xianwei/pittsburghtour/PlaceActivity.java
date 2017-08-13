package com.xianwei.pittsburghtour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    private String urlString;
    private String stringPhoneNumber;
    private String stringLocation;
    private String stringOpenTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        ButterKnife.bind(this);
        setupUI(getIntent());
    }

    private void setupUI(Intent intent) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        urlString = intent.getStringExtra("Website");
        stringPhoneNumber = intent.getStringExtra("Phone");
        stringLocation = intent.getStringExtra("Location");
        stringOpenTime = intent.getStringExtra("OpenTime");

        imageView.setImageResource(intent.getIntExtra("ImageResourceId", 0));
        title.setText(intent.getStringExtra("Title"));
        address.setText(stringLocation);

        if (stringOpenTime != null) {
            openTime.setText(stringOpenTime);
        } else {
            openTime.setVisibility(View.GONE);
        }

        phone.setText(stringPhoneNumber);
        website.setText(urlString);
        description.setText(intent.getStringExtra("Description"));
    }

    @OnClick(R.id.place_address_text_view)
    void openMap(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, geoLocation(stringLocation));
        startActivity(browserIntent);
    }

    @OnClick(R.id.place_website_text_view)
    void openWebsite(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
        startActivity(browserIntent);
    }

    @OnClick(R.id.place_phone_text_view)
    void call(View view) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse(stringPhoneNumberToUriString(stringPhoneNumber)));
        startActivity(callIntent);
    }

    private Uri geoLocation(String stringLocation) {
        StringBuilder result = new StringBuilder("geo:0,0?q=");
        result.append(stringLocation.replace(" ", "+").replace(",", "+"));
        return Uri.parse(result.toString());
    }

    String stringPhoneNumberToUriString(String phoneNumber) {
        StringBuilder result = new StringBuilder("tel:");
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (phoneNumber.charAt(i) >= '0' && phoneNumber.charAt(i) <= '9') {
                result.append(phoneNumber.charAt(i));
            }
        }
        return result.toString();
    }
}
