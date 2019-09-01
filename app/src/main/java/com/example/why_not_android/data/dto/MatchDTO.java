package com.example.why_not_android.data.dto;

import com.google.gson.annotations.SerializedName;

public class MatchDTO {
    @SerializedName("match")
    private Boolean match;
    @SerializedName("error")
    private String error;
    @SerializedName("name") private String name;
    @SerializedName("imageURL") private String  imageURL;


    public Boolean getMatch() {
        return match;
    }

    public void setMatch(Boolean match) {
        this.match = match;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

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

    @Override
    public String toString() {
        return "MatchDTO{" +
                "match='" + match + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}