package com.example.why_not_android.data.dto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ChatsDTO {

    @SerializedName("chats")
    private ArrayList<ChatDTO> chats;

    public ArrayList<ChatDTO> getChatsDTOArrayList() {
        return chats;
    }
}
