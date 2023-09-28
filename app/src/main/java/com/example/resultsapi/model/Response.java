package com.example.resultsapi.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Response implements Serializable {

    @SerializedName("results")
    public Data[]data;

}
