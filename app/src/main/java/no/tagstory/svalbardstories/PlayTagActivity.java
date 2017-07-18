package no.tagstory.svalbardstories;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

class PlayTagActivity extends Activity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tag_play);

        Tag tag = (Tag) getIntent().getExtras().get("TAG");
        int identifier = getResources().getIdentifier("SOME_FILE", "raw", getPackageName());
        mediaPlayer = MediaPlayer.create(this, identifier);
    }

    public void toggleAudio(View view) {
        if (view.getId() == R.id.button_audio) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            } else {
                mediaPlayer.start();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }
}
