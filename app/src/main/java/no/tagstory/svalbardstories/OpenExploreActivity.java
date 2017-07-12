package no.tagstory.svalbardstories;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;

public class OpenExploreActivity extends FragmentActivity {

	private static final String TAG = "OpenExploreActivity";
    private static final String OPEN_MAP_FRAGMENT_TAG = "OPEN_MAP_FRAGMENT_TAG";
    private static final String EXPLORE_LIST_FRAGMENT_TAG = "EXPLORE_LIST_FRAGMENT_TAG";

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
		Fragment fragment;
        String tag;
		if (v.getId() == R.id.button_map) {
            tag = OPEN_MAP_FRAGMENT_TAG;
            fragment = new OpenMapFragment();
		} else if (v.getId() == R.id.button_list) {
            tag = EXPLORE_LIST_FRAGMENT_TAG;
			// fragment = new ExploreListFragment();
			fragment = new ListFragment();
			ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new String[]{"hello", "world", "how" ,"I've", "missed", "you"});
			((ListFragment) fragment).setListAdapter(arrayAdapter);
		} else {
			return;
		}
		changeFragment(fragment, tag);
	}

	private void changeFragment(Fragment newFragment, String tag) {
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        Fragment myFragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (myFragment != null && myFragment.isVisible()) {
            // No reson to replace the same fragment
            return;
        }

        // Replace whatever is in the fragment_container view with this fragment,
		// and add the transaction to the back stack so the user can navigate back
		transaction.replace(R.id.fragment_explore, newFragment, tag);
		// transaction.addToBackStack(null);

		// Commit the transaction
		transaction.commit();
	}
}
