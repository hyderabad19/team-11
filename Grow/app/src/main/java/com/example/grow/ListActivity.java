package com.example.grow;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.CircularProgressDrawable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListActivity extends Activity {
    // Array of strings...

    //CircularProgressDrawable.ProgressDrawableSize pd;
    JSONObject res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

       // new JsonTask().execute("http://localhost:8080/user/getvideos");
        String url = "http://10.0.2.2:8080/user/getvideos";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // Initialize a new JsonObjectRequest instance
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Do something with response
                        //mTextView.setText(response.toString());

                        // Process the JSON
                        // Get the JSON array
//                            JSONArray array = response.getJSONArray("students");
//
//                            // Loop through the array elements
//                            for(int i=0;i<array.length();i++){
//                                // Get current json object
//                                JSONObject student = array.getJSONObject(i);
//
//                                // Get the current student (json object) data
//                                String firstName = student.getString("firstname");
//                                String lastName = student.getString("lastname");
//                                String age = student.getString("age");
//
//                                // Display the formatted json data in text view
//                                mTextView.append(firstName +" " + lastName +"\nage : " + age);
//                                mTextView.append("\n\n");
//                            }
                        res = response;
                        Log.d("JSONReq",response.toString());
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        // Do something when error occurred
                        Log.d("err",error.getMessage());
                    }
                }
        );
        /*StringRequest postRequest = new StringRequest(
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
        };*/
        requestQueue.add(jsonObjectRequest);
        String[] mobile_array={"abc0","def"};
        String resString = "";

       try {
           resString = res.getJSONObject("contentLocation").getJSONObject("data").toString();
       }catch(JSONException j) {
           Log.d("err",j.toString());
       }
       Log.d("RESST",resString);



                   // Add JsonObjectRequest to the RequestQueue
                   ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobile_array);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String title = (String) parent.getItemAtPosition(position);
                        Intent i = new Intent(ListActivity.this, VideoActivity.class);
                        i.putExtra("tile",title);
                        startActivity(i);
                    }
                }
        );
    }


}


