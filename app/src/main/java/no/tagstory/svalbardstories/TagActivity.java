package no.tagstory.svalbardstories;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;


public class TagActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tag_details);
        Tag tag = (Tag) getIntent().getExtras().get("TAG");
        TextView title = (TextView) findViewById(R.id.title);
        title.setText(tag.getTitle());
        TextView type = (TextView) findViewById(R.id.type);
        type.setText(tag.getType());
        TextView description = (TextView) findViewById(R.id.description);
        description.setText(tag.getDescription());

        setTitle(tag.getTitle());
    }

    public void playStory(View view) {
        if (view.getId() == R.id.button_play_story) {
            // TODO: Change the activity to media player, or maybe I should use fragments?
        }
    }
}
