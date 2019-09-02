package com.example.why_not_android.views;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.why_not_android.R;
import com.example.why_not_android.data.Models.Chat;
import com.example.why_not_android.data.SharedPreferences.SharedPref;
import com.example.why_not_android.data.adapter.ChatAdapter;
import com.example.why_not_android.data.service.providers.NetworkProvider;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Chats extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.activity_chat_conversation_recyclerView)
    RecyclerView conversationRcv;

    @BindView(R.id.activity_chat_send_btn)
    Button sendBtn;

    @BindView(R.id.activity_chat_text_edt)
    EditText messageEdt;

    private ChatAdapter chatAdapter;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);
        sharedPreferences = SharedPref.getInstance(this);
        initRcv();
        loadData();
    }

    private void initRcv() {
        Log.d("init", "init");
        conversationRcv.setLayoutManager(new LinearLayoutManager(this));
        chatAdapter = new ChatAdapter();
        conversationRcv.setAdapter(chatAdapter);
        chatAdapter.setItemClickListener(new ChatAdapter.ItemClickListener() {
            @Override
            public void onclick(Chat Chat) {

            }
        });
    }

    private void loadData() {
        NetworkProvider.getInstance().getChats(new NetworkProvider.Listener<List<Chat>>() {
            @Override
            public void onSuccess(List<Chat> data) {
                chatAdapter.setChatList(data);
            }

            @Override
            public void onError(Throwable t) {

            }
        });
    }
}
