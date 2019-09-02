package com.example.why_not_android.data.dto.mapper;

import android.util.Log;

import com.example.why_not_android.data.SharedPreferences.SharedPref;
import com.example.why_not_android.data.dto.MatchDTO;
import com.example.why_not_android.data.dto.MatchsDTO;
import com.example.why_not_android.data.Models.Match;

import java.util.ArrayList;
import java.util.List;

public class MatchMapper {

    public static List<Match> map(List<MatchDTO> matchDTOList) {
        List<Match> matchList = new ArrayList<>();
        Log.d("matchs",matchDTOList.toString());
        for (MatchDTO matchDTO : matchDTOList) {

            matchList.add(map(matchDTO));
        }
        return matchList;
    }

    private static Match map(MatchDTO matchDTO) {
        Match match = new Match();
        if(matchDTO.getemailUser1().equals(SharedPref.getEmail())){
            match.setName(matchDTO.getemailUser2());
        }else{
            match.setName(matchDTO.getemailUser1());
        }


        return match;
    }
}
