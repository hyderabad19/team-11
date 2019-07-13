package com.example.grow;
import android.content.Intent;
import android.net.Uri;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.app.DownloadManager.Request;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class PlayActivity extends AppCompatActivity{
    TextView buttonA,buttonB,buttonC,buttonD,question,coin;
    int count=0;
    int qid=0;
    String correctAnswer="OptionA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        question=(TextView)findViewById(R.id.triviaQuestion);
        buttonA=(TextView)findViewById(R.id.buttonA);
        buttonB=(TextView)findViewById(R.id.buttonB);
        buttonC=(TextView)findViewById(R.id.buttonC);
        buttonD=(TextView)findViewById(R.id.buttonD);
        coin=(TextView)findViewById(R.id.coinText);
        question.setText("question1");
        buttonA.setText("OptionA");
        buttonB.setText("OptionB");
        buttonC.setText("OptionC");
        buttonD.setText("OptionD");
        qid++;
        coin.setText(String.valueOf(count));

        String url="";
        StringRequest postRequest = new StringRequest(
                Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("email", "rahulmora007@gmail.com");
                params.put("password", "rahul");

                return params;
            }
        };
        requestQueue.add(jsonObjectRequest);

    }
    public void onClick2(View view1)
    {
        if(correctAnswer==buttonA.getText())
            count++;
        while(qid<9)
            updateQuestion();


    }
    public void updateQuestion()
    {
        question=(TextView)findViewById(R.id.triviaQuestion);
        buttonA=(TextView)findViewById(R.id.buttonA);
        buttonB=(TextView)findViewById(R.id.buttonB);
        buttonC=(TextView)findViewById(R.id.buttonC);
        buttonD=(TextView)findViewById(R.id.buttonD);
        question.setText("question2");
        buttonA.setText("Option2");
        buttonB.setText("Option2");
        buttonC.setText("Option2");
        buttonD.setText("Option2");
        qid++;
        coin.setText(String.valueOf(count));

    }

}
