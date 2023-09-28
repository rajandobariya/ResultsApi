package com.example.resultsapi.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Name implements Serializable {

    @SerializedName("title")
    public String title;
    @SerializedName("first")
    public String firstname;
    @SerializedName("last")
    public String lastname;
}
