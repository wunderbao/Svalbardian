package no.tagstory.svalbardstories.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import no.tagstory.svalbardstories.R;
import no.tagstory.svalbardstories.Story;
import no.tagstory.svalbardstories.Tag;
import no.tagstory.svalbardstories.TagActivity;

public class OpenMapFragment extends Fragment implements MapboxMap.OnMarkerClickListener {

	private MapView mapView;
    private Story story;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		Mapbox.getInstance(getContext(), "pk.eyJ1Ijoia3lycmVtYW5uIiwiYSI6ImNqM24zbmNzYTAwMGgyeHBjMWE5a3B0dm4ifQ.v0mgMFY7TbQb_1VQRc6Y6Q");

		return inflater.inflate(R.layout.fragment_open_map, container, false);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

        Bundle extras = getActivity().getIntent().getExtras();
        story = (Story) extras.get("STORY");
        mapView = (MapView) getView().findViewById(R.id.open_map);
		mapView.onCreate(savedInstanceState);
		mapView.getMapAsync(new OnMapReadyCallback() {
			@Override
			public void onMapReady(MapboxMap mapboxMap) {

                // Customize map with markers, polylines, etc.
                mapboxMap.setCameraPosition(story.getCameraPosition());
                for (Tag tag : story.getTags()) {
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.setPosition(tag.getLatLng())
                            .setTitle(tag.getTitle());
                    mapboxMap.addMarker(markerOptions);
                }

                mapboxMap.setOnMarkerClickListener(OpenMapFragment.this);
            }
		});
	}

	@Override
	public void onStart() {
		super.onStart();
		mapView.onStart();
	}

	@Override
	public void onResume() {
		super.onResume();
		mapView.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
		mapView.onPause();
	}

	@Override
	public void onStop() {
		super.onStop();
		mapView.onStop();
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		mapView.onLowMemory();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mapView.onDestroy();
		mapView = null;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		mapView.onSaveInstanceState(outState);
	}

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        for (Tag tag : story.getTags()) {
            if (tag.getTitle().equals(marker.getTitle())) {
                Intent intent = new Intent(getContext(), TagActivity.class);
                intent.putExtra("TAG", tag);
                startActivity(intent);
                return true;
            }
        }
        return false;
    }
}
