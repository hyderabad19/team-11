package com.example.grow;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* String path="https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4";

        VideoView videoview = (VideoView) findViewById(R.id.videoView1);
        Uri uri = Uri.parse(path);
        videoview.setVideoURI(uri);
        videoview.start();*/

       Button button = (Button) findViewById(R.id.button);

    }

    public void onClick(View view) {
        Intent i = new Intent(this, ListActivity.class);
        startActivity(i);
    }

}
