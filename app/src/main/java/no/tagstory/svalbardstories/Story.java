package no.tagstory.svalbardstories;

import com.google.gson.annotations.SerializedName;
import com.mapbox.mapboxsdk.geometry.LatLng;

import java.io.Serializable;
import java.util.List;

public class Story implements Serializable {

    private String UUID;
//    @SerializedName("created_time")
//    private Date createdTime;
//    @SerializedName("updated_time")
//    private Date updatedTime;
    @SerializedName("map_focus")
    private LatLng location;
    @SerializedName("camera_zoom")
    private int cameraZoom;
    private List<Tag> tags;

    public String getUUID() {
        return UUID;
    }

    public int getCameraZoom() {
        return cameraZoom;
    }

    public LatLng getLocation() {
        return location;
    }

    public List<Tag> getTags() {

        return tags;
    }
}
