package com.example.resultsapi.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Street implements Serializable {
    @SerializedName("name")
    public String name;
    @SerializedName("number")
    public String number;
}
