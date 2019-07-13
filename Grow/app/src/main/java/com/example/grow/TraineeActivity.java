package com.example.grow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TraineeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainee);
    }
    public void Forum(View view){
       // Intent i = new Intent(TraineeActivity.this, ForumActivity.class);
        //startActivity(i);
    }
    public void alertClick(View view){
       // Intent i = new Intent(TraineeActivity.this, AlertActivity.class);
        //startActivity(i);
    }
}
