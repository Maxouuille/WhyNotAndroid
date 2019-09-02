package com.example.why_not_android.data.service;

import com.example.why_not_android.data.dto.MatchsDTO;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface MatchsService {

    @GET("matchs")
    Call<MatchsDTO> getAllMatchFromUser(@Header("x-access-token") String token);
}
