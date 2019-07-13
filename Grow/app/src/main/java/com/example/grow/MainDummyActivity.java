package com.example.grow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainDummyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maindummy);
    }
    public void userClick(View view)
    {
        Intent i=new Intent(MainDummyActivity.this,Login.class);
        startActivity(i);
    }
    public void traineeClick(View view)
    {
        Intent i=new Intent(MainDummyActivity.this,Reg.class);
        startActivity(i);
    }
    public void adminClick(View view)
    {
        Intent i=new Intent(MainDummyActivity.this,Admin.class);
        startActivity(i);
    }
}
