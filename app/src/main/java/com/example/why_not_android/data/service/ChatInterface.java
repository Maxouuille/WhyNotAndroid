package com.example.why_not_android.data.service;

import com.example.why_not_android.data.dto.ChatsDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ChatInterface {

    @GET
    Call<ChatsDTO> getOneChat(@Header("x-access-token") String token, @Query("_id") String idUser, @Query("_id") String idUser2);




}
