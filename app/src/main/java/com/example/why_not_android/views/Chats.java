package com.example.why_not_android.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.why_not_android.R;
import com.example.why_not_android.data.Models.Chat;
import com.example.why_not_android.data.SharedPreferences.SharedPref;
import com.example.why_not_android.data.adapter.ChatAdapter;
import com.example.why_not_android.data.dto.MessageDTO;
import com.example.why_not_android.data.service.ChatsService;
import com.example.why_not_android.data.service.SessionService;
import com.example.why_not_android.data.service.providers.NetworkProvider;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    @OnClick(R.id.activity_chat_send_btn) void onNextButtonClick() {
        Toast.makeText(Chats.this, "Test",Toast.LENGTH_SHORT).show();
        ChatsService messageService;
        messageService = NetworkProvider.getClient().create(ChatsService.class);

   /*
        RequestBody emailSender =
                RequestBody.create(
                        okhttp3.MultipartBody.FORM, SharedPref.getEmail());
        RequestBody emailReciver =
                RequestBody.create(
                        okhttp3.MultipartBody.FORM, SharedPref.getEmailUser2());
        RequestBody message =
                RequestBody.create(
                        okhttp3.MultipartBody.FORM, messageEdt.getText().toString());
        Call<MessageDTO> call = messageService.sendMessage(
                SharedPref.getToken(),
                emailSender,
                emailReciver,
                message
        );
         call.enqueue(new Callback<MessageDTO>() {
    */

        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setEmailSender(SharedPref.getEmailUser2());
        messageDTO.setEmailReciver(SharedPref.getEmail());
        messageDTO.setMessage(messageEdt.getText().toString());
        Call<MessageDTO> messageDTOCall = messageService.sendMessage2(SharedPref.getToken(), messageDTO);

        messageDTOCall.enqueue(new Callback<MessageDTO>() {

            @Override
            public void onResponse(Call<MessageDTO> call, Response<MessageDTO> response) {
                Toast.makeText(Chats.this, "Test2",Toast.LENGTH_SHORT).show();
                messageEdt.setText("");
                loadData();
            }

            @Override
            public void onFailure(Call<MessageDTO> call, Throwable t) {
                Toast.makeText(Chats.this, "Impossible d'envoyé votre message, verifiez votre connexion",Toast.LENGTH_SHORT).show();
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
