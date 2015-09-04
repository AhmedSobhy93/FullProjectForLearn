package com.example.ahmed.calculator;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Audio extends ActionBarActivity {

    Button playBtn;
    VideoView vedioV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        playBtn = (Button) findViewById(R.id.Audio_Play_Button);

        //Error Can't play The Video
        //how i can upload video to server then play it in Activity using account ...

        vedioV = (VideoView) findViewById(R.id.videoView);
        vedioV.setVideoPath("/Internal storage/2015/SourceCode.mp4");
        vedioV.setMediaController(new MediaController(this));
        vedioV.start();
        vedioV.requestFocus();

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MediaPlayer mp = MediaPlayer.create(Audio.this, R.raw.beep);
                mp.start();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_audio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
