package no.tagstory.svalbardstories;

import com.mapbox.mapboxsdk.geometry.LatLng;

import java.io.Serializable;

class Tag implements Serializable {

    private String UUID;
    private String title;
    private String description;
    private LatLng location;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LatLng getLocation() {
        return location;
    }
}
