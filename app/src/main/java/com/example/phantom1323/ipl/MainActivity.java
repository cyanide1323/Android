package com.example.phantom1323.ipl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.listView);
        CustomAdapter customAdapter;
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2:4141/ipl_matches";
        final ArrayList<Datamodel> list = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("");
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject1 = new JSONObject(jsonArray.getString(i));
                                list.add(new Datamodel(jsonObject1.getString("team1"),jsonObject1.getString("team2")));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"Network Error",Toast.LENGTH_LONG).show();
            }
        });
        customAdapter = new CustomAdapter(list,getApplicationContext());
        queue.add(stringRequest);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // call the second activity showing details
            }
        });
    }
}
