package com.example.why_not_android.data.dto.mapper;

import android.util.Log;

import com.example.why_not_android.data.Models.Chat;
import com.example.why_not_android.data.SharedPreferences.SharedPref;
import com.example.why_not_android.data.dto.ChatDTO;

import java.util.ArrayList;
import java.util.List;

public class ChatMapper {

    public static List<Chat> map(List<ChatDTO> chatDTOList) {
        List<Chat> chatList = new ArrayList<>();
        Log.d("chats",chatDTOList.toString());
        for (ChatDTO chatDTO : chatDTOList) {
            chatList.add(map(chatDTO));
        }
        return chatList;
    }

    private static Chat map(ChatDTO chatDTO) {
        Chat chat = new Chat();
        chat.setMessage(chatDTO.getMessage());
        return chat;
    }
}
