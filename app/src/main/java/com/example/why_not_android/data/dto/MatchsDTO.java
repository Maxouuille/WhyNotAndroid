package com.example.why_not_android.data.dto;

import com.example.why_not_android.data.service.MatchsService;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MatchsDTO {

    @SerializedName("name") private String name;
    @SerializedName("imageURL") private String  imageURL;

    @SerializedName("matchs") private ArrayList<MatchsDTO> matchs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }



    public ArrayList<MatchsDTO> getMatchsDTOArrayList() {
        return matchs;
    }



}
