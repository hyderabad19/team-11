package com.example.grow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class QuizActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    public void onClick1(View view)
    {
        Intent i = new Intent(QuizActivity.this, PlayActivity.class);
        startActivity(i);
    }

}
