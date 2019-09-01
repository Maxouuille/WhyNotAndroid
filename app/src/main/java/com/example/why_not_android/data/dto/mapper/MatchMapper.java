package com.example.why_not_android.data.dto.mapper;

import android.util.Log;

import com.example.why_not_android.data.dto.MatchsDTO;
import com.example.why_not_android.data.Models.Match;

import java.util.ArrayList;
import java.util.List;

public class MatchMapper {

    public static List<Match> map(List<MatchsDTO> matchDTOList) {
        List<Match> matchList = new ArrayList<>();
        for (MatchsDTO matchDTO : matchDTOList) {
            Log.d("matchs",matchDTO.toString());
            matchList.add(map(matchDTO));
        }
        return matchList;
    }

    private static Match map(MatchsDTO matchDTO) {
        Match match = new Match();
        match.setName(matchDTO.getName());
        match.setImageURL(matchDTO.getImageURL());
        return match;
    }
}
