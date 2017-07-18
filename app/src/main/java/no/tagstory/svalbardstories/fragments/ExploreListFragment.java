package no.tagstory.svalbardstories.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import no.tagstory.svalbardstories.R;
import no.tagstory.svalbardstories.Story;
import no.tagstory.svalbardstories.Tag;
import no.tagstory.svalbardstories.TagActivity;

public class ExploreListFragment extends ListFragment {

	private Story story;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        story = (Story) getActivity().getIntent().getExtras().getSerializable("STORY");
		return inflater.inflate(R.layout.fragment_list, container, false);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
        String[] items = new String[story.getTags().size()];
        for (int i = 0; i < story.getTags().size(); i++) {
            items[i] = story.getTags().get(i).getTitle();
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, items);
        setListAdapter(arrayAdapter);
	}

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        String title = ((TextView) view).getText().toString();
        for (Tag tag : story.getTags()) {
            if (tag.getTitle().equals(title)) {
                Intent intent = new Intent(getContext(), TagActivity.class);
                intent.putExtra("TAG", tag);
                startActivity(intent);
                return;
            }
        }
    }
}
