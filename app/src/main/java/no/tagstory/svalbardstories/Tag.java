package no.tagstory.svalbardstories;

import com.mapbox.mapboxsdk.geometry.LatLng;

import java.io.Serializable;

public class Tag implements Serializable {

    private static final long serialVersionUID = 5054220365681779111L;

    private String UUID;
    private String title;
    private String description;
    private double latitude;
    private double longitude;
    private String type;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LatLng getLatLng() {
        return new LatLng(latitude, longitude);
    }

    public String getType() {
        return type;
    }
}
