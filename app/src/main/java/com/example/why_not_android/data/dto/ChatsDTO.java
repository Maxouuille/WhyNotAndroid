package com.example.why_not_android.data.dto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ChatsDTO {

    @SerializedName("chats")
    private ArrayList<ChatsDTO> chats;

    public ArrayList<ChatsDTO> getChatsDTOArrayList() {
        return chats;
    }
}
