package com.example.resultsapi.model;


import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Data implements Serializable {

    @SerializedName("gender")
    public String gender;
    @SerializedName("email")
    public String email;
    @SerializedName("phone")
    public String phone;
    @SerializedName("cell")
    public String cell;
    @SerializedName("nat")
    public String nat;
    @SerializedName("name")
    public Name name;
    @SerializedName("location")
    public Location location;
    @SerializedName("picture")
    public Picture picture;
}
