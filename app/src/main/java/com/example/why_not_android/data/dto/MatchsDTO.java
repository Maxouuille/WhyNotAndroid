package com.example.why_not_android.data.dto;

import com.example.why_not_android.data.service.MatchsService;
import com.example.why_not_android.views.Matchs;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MatchsDTO {

    @SerializedName("emailUser1") private String emailUser1;
    @SerializedName("emailUser2") private String  emailUser2;

    @SerializedName("matchs") private ArrayList<MatchDTO> matchs;

    public String getEmailUser1() {
        return emailUser1;
    }

    public void setEmailUser1(String emailUser1) {
        this.emailUser1 = emailUser1;
    }

    public String getEmailUser2() {
        return emailUser2;
    }

    public void setEmailUser2(String emailUser2) {
        this.emailUser2 = emailUser2;
    }

    public ArrayList<MatchDTO> getMatchsDTOList() {
        return matchs;
    }



}
