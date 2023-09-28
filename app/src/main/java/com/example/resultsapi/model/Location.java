package com.example.resultsapi.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Location implements Serializable {

    @SerializedName("city")
    public String city;
    @SerializedName("state")
    public  String state;
    @SerializedName("country")
    public String country;
    @SerializedName("postcode")
    public String postcode;
    @SerializedName("street")
    public Street street;
}
