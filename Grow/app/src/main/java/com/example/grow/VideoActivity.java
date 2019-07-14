package com.example.grow;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        String path="https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4";
        TextView title = (TextView) findViewById(R.id.title);
        TextView desc = (TextView) findViewById(R.id.desc);
        Bundle bundle = getIntent().getExtras();
        String titleData =bundle.getString("tile");

        title.setText("Tile of the video");
        desc.setText("Video about a topic either general or specific and goes on multiple lines");

        VideoView videoview = (VideoView) findViewById(R.id.videoView1);
        Uri uri = Uri.parse(path);
        videoview.setVideoURI(uri);
        videoview.start();

    }



}
