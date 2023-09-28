package com.example.resultsapi;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.resultsapi.adapter.DataAdapter;
import com.example.resultsapi.model.Data;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DataAdapter dataAdapter;
    ArrayList<Data> dataArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        dataAdapter = new DataAdapter(this, dataArrayList);
        recyclerView.setAdapter(dataAdapter);


        String url = "https://randomuser.me/api/?results=20";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                com.example.resultsapi.model.Response data = gson.fromJson(String.valueOf(response), com.example.resultsapi.model.Response.class);
                dataArrayList.addAll(Arrays.asList(data.data));
                dataAdapter.notifyDataSetChanged();
                /* try {
                    JSONArray jsonArray = response.getJSONArray("results");
                    for (int i = 0; i < jsonArray.length(); i++) {

                       // JSONObject jsonObject=(JSONObject) jsonArray.get(i);
                        String gender =jsonObject.getString("gender");
                        String email =jsonObject.getString("email");
                        String phone =jsonObject.getString("phone");
                        String cell =jsonObject.getString("cell");
                        String nat =jsonObject.getString("nat");
                        JSONObject jsonObject1 = jsonObject.getJSONObject("name");
                        JSONObject jsonObject2 = jsonObject.getJSONObject("location");
                        String title = null;
                        String firstname= null;
                        String lastname = null;
                        String city =null;
                        String state = null;
                        String postcode=null;
                        String country =null;



                        for (int j = 0; j < jsonObject2.length(); j++) {
                            city =jsonObject2.getString("city");
                            state =jsonObject2.getString("state");
                            postcode =jsonObject2.getString("postcode");
                            country =jsonObject2.getString("country");
                        }
                        for (int j = 0; j < jsonObject1.length(); j++) {
                            title = jsonObject1.getString("title");
                            firstname =jsonObject1.getString("first");
                            lastname =jsonObject1.getString("last");
                        }
//                        Data data =new Data(gender,email,phone,cell,nat,title,firstname,lastname,city,state,country,postcode);
//                        dataArrayList.add(data);*//*
                        GsonBuilder gsonBuilder =new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        Data[] data = gson.fromJson(String.valueOf(response),Data[].class);
                        dataArrayList.addAll(Arrays.asList(data));
                        dataAdapter.notifyDataSetChanged();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}