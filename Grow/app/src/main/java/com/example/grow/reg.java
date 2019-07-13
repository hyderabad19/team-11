package com.example.grow;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;

public class reg extends Activity {

    private Button buttonRegister;
    private EditText Name;
    private EditText editTextEmail;
    private EditText editTextPassword;
    //private TextView textViewSignin;
    private EditText textdob;
    private EditText textGender;
    private TextView text;
    private ProgressDialog progressDialog;
    RequestQueue requestQueue;
    String url="http://localhost:8080/user/register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        progressDialog = new ProgressDialog(this);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);
        Name = (EditText) findViewById(R.id.name);
        textdob = (EditText) findViewById(R.id.DOB);
        textGender = (EditText) findViewById(R.id.gender);
       /* buttonRegister.setOnClickListener(
                {
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {

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
                                        params.put("name",Name.getText().toString());
                                        params.put("password",editTextPassword.getText().toString() );
                                        params.put("password",editTextPassword.getText().toString() );
                                        params.put("DOB",textdob.getText().toString() );
                                        params.put("gender",textGender.getText().toString());


                                        return params;
                                    }
                                };
                                requestQueue.add(postRequest);
                            }
                        }
                }
        );*/
    }
}




