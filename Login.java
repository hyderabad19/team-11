package com.example.DrReddys;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.login.R;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    private static EditText username;
    private static EditText password;
    private static Button signup_button;
    private static Button login_button;
    int attempt_counter=5;
    RequestQueue requestQueue;
    String url = "http://localhost:8080/user/login";


    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginButton();
    }

    public void LoginButton(){
        username = (EditText)findViewById(R.id.editText_user);
        password = (EditText)findViewById(R.id.editText_password);
        login_button = (Button)findViewById(R.id.button_login);
        signup_button = (Button)findViewById(R.id.button_signup);

        login_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

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
                                params.put("email", username.getText().toString());
                                params.put("password",password.getText().toString());

                                return params;
                            }
                        };
                        requestQueue.add(postRequest);
                    }
                      /* if (username.getText().toString().equals("user") && //&amp;amp;amp;&amp;amp;amp;
                        password.getText().toString().equals("pass")){
                            Toast.makeText(Login.this,"Username and password is correct",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent("com.example.login.User");
                            startActivity(intent);

                        }
                        else {
                            Toast.makeText(Login.this,"Username and password is NOT correct",
                                    Toast.LENGTH_SHORT).show();
                            attempt_counter--;
                            //attempt.setText(Integer.toString(attempt_counter));
                            if(attempt_counter==0)
                                login_button.setEnabled(false);
                        }*/

                }
        );

        signup_button.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent intent = new Intent("com.example.login.User");
                        startActivity(intent);
                    }
                }
        );
    }
}

