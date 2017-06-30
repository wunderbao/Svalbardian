package no.tagstory.svalbardstories;

import android.app.Activity;
import android.os.Bundle;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

public class OpenExploreActivity extends Activity {

	private MapView mapView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Mapbox access token is configured here. This needs to be called either in your application
		// object or in the same activity which contains the mapview.
		Mapbox.getInstance(this, "pk.eyJ1Ijoia3lycmVtYW5uIiwiYSI6ImNqM24zbmNzYTAwMGgyeHBjMWE5a3B0dm4ifQ.v0mgMFY7TbQb_1VQRc6Y6Q");

		// This contains the MapView in XML and needs to be called after the access token is configured.
		setContentView(R.layout.activity_open_explore);

		mapView = (MapView) findViewById(R.id.open_map);
		mapView.onCreate(savedInstanceState);
		mapView.getMapAsync(new OnMapReadyCallback() {
			@Override
			public void onMapReady(MapboxMap mapboxMap) {

				// Customize map with markers, polylines, etc.

			}
		});
	}

	// Add the mapView lifecycle to the activity's lifecycle methods
	@Override
	protected void onStart() {
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
	protected void onStop() {
		super.onStop();
		mapView.onStop();
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		mapView.onLowMemory();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mapView.onDestroy();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		mapView.onSaveInstanceState(outState);
	}
}
