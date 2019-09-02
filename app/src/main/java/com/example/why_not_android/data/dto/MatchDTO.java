package com.example.why_not_android.data.dto;

import com.google.gson.annotations.SerializedName;

public class MatchDTO {
    @SerializedName("match")
    private Boolean match;
    @SerializedName("error")
    private String error;
    @SerializedName("emailUser1") private String emailUser1;
    @SerializedName("emailUser2") private String  emailUser2;


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

    public String getemailUser1() {
        return emailUser1;
    }

    public void setemailUser1(String name) {
        this.emailUser1 = name;
    }

    public String getemailUser2() {
        return emailUser2;
    }

    public void setemailUser2(String imageURL) {
        this.emailUser2 = imageURL;
    }

    @Override
    public String toString() {
        return "MatchDTO{" +
                "match='" + match + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}