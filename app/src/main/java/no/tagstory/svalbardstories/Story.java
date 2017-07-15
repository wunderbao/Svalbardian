package no.tagstory.svalbardstories;

import com.google.gson.annotations.SerializedName;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.geometry.LatLng;

import java.io.Serializable;
import java.util.List;

public class Story implements Serializable {

    private static final long serialVersionUID = -6793337388342862407L;

    private String UUID;
//    @SerializedName("created_time")
//    private Date createdTime;
//    @SerializedName("updated_time")
//    private Date updatedTime;
    private double latitude;
    private double longitude;
    @SerializedName("camera_zoom")
    private int cameraZoom;
    private List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    public CameraPosition getCameraPosition() {
        CameraPosition.Builder builder = new CameraPosition.Builder();
        return builder.target(new LatLng(latitude, longitude)).zoom(cameraZoom).build();
    }
}
