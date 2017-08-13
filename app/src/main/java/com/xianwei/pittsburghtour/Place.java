package com.xianwei.pittsburghtour;

/**
 * Created by xianwei li on 8/11/2017.
 */

public class Place {
    private int imageResourceId;
    private float rating;
    private String title;
    private String introduction;
    private String location;
    private String openTime;
    private String phone;
    private String website;
    private String description;

    public Place(int imageResourceId, float rating, String title, String introduction, String location, String openTime, String phone, String website, String description) {
        this.imageResourceId = imageResourceId;
        this.rating = rating;
        this.title = title;
        this.introduction = introduction;
        this.location = location;
        this.openTime = openTime;
        this.phone = phone;
        this.website = website;
        this.description = description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public float getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getLocation() {
        return location;
    }

    public String getOpenTime() {
        return openTime;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public String getDescription() {
        return description;
    }
}
