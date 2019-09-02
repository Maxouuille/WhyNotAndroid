package com.example.why_not_android.data.dto;

import com.example.why_not_android.data.service.MatchsService;
import com.example.why_not_android.views.Matchs;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MatchsDTO {

    @SerializedName("matchs") private ArrayList<MatchDTO> matchs;

    public ArrayList<MatchDTO> getMatchsDTOList() {
        return matchs;
    }



}
