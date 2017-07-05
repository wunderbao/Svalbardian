package no.tagstory.svalbardstories;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;

public class OpenExploreActivity extends FragmentActivity {

	private static final String TAG = "OpenExploreActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_open_explore_fragment);

		// Check that the activity is using the layout version with
		// the fragment_container FrameLayout
		if (findViewById(R.id.fragment_explore) != null) {

			// However, if we're being restored from a previous state,
			// then we don't need to do anything and should return or else
			// we could end up with overlapping fragments.
			if (savedInstanceState != null) {
				return;
			}

			// Create a new Fragment to be placed in the activity layout
			OpenMapFragment openMapFragment = new OpenMapFragment();

			// In case this activity was started with special instructions from an
			// Intent, pass the Intent's extras to the fragment as arguments
			openMapFragment.setArguments(getIntent().getExtras());

			// Add the fragment to the 'fragment_container' FrameLayout
			getSupportFragmentManager().beginTransaction()
					.add(R.id.fragment_explore, openMapFragment).commit();
		}
	}


	public void switchView(View v) {
		if (v.getId() == R.id.button_map) {
			Log.d("OpenExploreActivity", "Map button");
		} else if (v.getId() == R.id.button_list) {
			Log.d("OpenExploreActivity", "List button");
		}
	}
}
