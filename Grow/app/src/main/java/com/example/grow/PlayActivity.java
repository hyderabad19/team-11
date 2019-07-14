package com.example.grow;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
//import android.app.DownloadManager.Request;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class PlayActivity extends AppCompatActivity{
    TextView buttonA,buttonB,buttonC,buttonD,question,coin;
    int count=0;
    int qid=0;
    String correctAnswer="(1/8)";
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
        question.setText("Look at the series 2,1,(1/2),(1/4),... What number should come next");
        buttonA.setText("(1/3)");
        buttonB.setText("(1/8)");
        buttonC.setText("(2/8)");
        buttonD.setText("(1/16)");
        coin.setText(String.valueOf(count));

        String url="https://10.0.2.2:8080/user/quiz";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
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
        requestQueue.add(postRequest);

    }
    public void onClick4(View v)
    {
        switch (v.getId()){
            case R.id.buttonA:
                if(buttonA.getText() == correctAnswer){
                    Toast.makeText(PlayActivity.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    count++;
                    qid++;
                    updateQuestion();
                }else{
                    GameOver();
                }
                break;

            case R.id.buttonB:
                if(buttonB.getText() == correctAnswer){
                    Toast.makeText(PlayActivity.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    count++;
                    qid++;
                    updateQuestion();
                }else{
                    GameOver();
                }

                break;

            case R.id.buttonC:
                if(buttonC.getText() == correctAnswer){
                    Toast.makeText(PlayActivity.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    count++;
                    qid++;
                    updateQuestion();
                }else{
                    GameOver();
                }

                break;

            case R.id.buttonD:
                if(buttonD.getText() == correctAnswer){
                    Toast.makeText(PlayActivity.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    count++;
                    qid++;
                    updateQuestion();
                }else {
                    GameOver();
                }

                break;
        }


    }
    private void GameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PlayActivity.this);
        alertDialogBuilder
                .setMessage("Game Over")
                .setCancelable(false)
                .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });
        alertDialogBuilder.show();

    }
    public void updateQuestion()
    {
        question=(TextView)findViewById(R.id.triviaQuestion);
        buttonA=(TextView)findViewById(R.id.buttonA);
        buttonB=(TextView)findViewById(R.id.buttonB);
        buttonC=(TextView)findViewById(R.id.buttonC);
        buttonD=(TextView)findViewById(R.id.buttonD);
        question.setText("Look at the series:7,10,8,11,9,12,....What number should come next?");
        buttonA.setText("7");
        buttonB.setText("10");
        buttonC.setText("12");
        buttonD.setText("13");
        correctAnswer="7";
        coin.setText(String.valueOf(count));
            //Toast.makeText(PlayActivity.this, "You Marks:"+count, Toast.LENGTH_LONG).show();

    }

}
