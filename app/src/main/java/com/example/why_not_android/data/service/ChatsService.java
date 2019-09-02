package com.example.why_not_android.data.service;


import com.example.why_not_android.data.dto.ChatsDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ChatsService {

    @GET("chats")
    Call<ChatsDTO> getAllChatBetweenTwoUser(@Header("x-access-token") String token);
}
