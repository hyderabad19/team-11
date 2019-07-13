package com.example.grow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }
    public void videosClick(View view){
        Intent i = new Intent(UserActivity.this, ListActivity.class);
        startActivity(i);
    }
    public void quizClick(View view){
        Intent i = new Intent(UserActivity.this, QuizActivity.class);
        startActivity(i);
    }
    public void ForumClick(View view){
        // Intent i = new Intent(UserActivity.this, ForumActivity.class);
        // startActivity(i);
    }
    public void HelpClick(View view){
        // Intent i = new Intent(UserActivity.this, HelpActivity.class);
        // startActivity(i);
    }
}
