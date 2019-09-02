package com.example.why_not_android.data.service;


import com.example.why_not_android.data.dto.ChatsDTO;
import com.example.why_not_android.data.dto.MessageDTO;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ChatsService {

    @GET("chats")
    Call<ChatsDTO> getAllChatBetweenTwoUser(@Header("x-access-token") String token);

    @Multipart
    @POST("chats/send")
    Call<MessageDTO> sendMessage(
            @Header("x-access-token") String token,
            @Part("emailSender") RequestBody emailSender,
            @Part("emailReciver") RequestBody emailReciver,
            @Part("message") RequestBody message
    );

    @POST("chats/send")
    Call<MessageDTO> sendMessage2(@Header("x-access-token") String token, @Body MessageDTO messageDTO);
}
