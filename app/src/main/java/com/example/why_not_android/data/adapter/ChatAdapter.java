package com.example.why_not_android.data.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.why_not_android.R;
import com.example.why_not_android.data.Models.Chat;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
    private List<Chat> ChatList;
    private ChatAdapter.ItemClickListener itemClickListener;

    public void setChatList(List<Chat> ChatList) {
        this.ChatList = ChatList;
        notifyDataSetChanged();
    }

    public void setItemClickListener(ChatAdapter.ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override public ChatAdapter.ChatViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_chat, viewGroup, false);
        return new ChatAdapter.ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ChatViewHolder chatViewHolder, int i) {

        Chat Chat = ChatList.get(i);
        chatViewHolder.nameTv.setText(Chat.getMessage());

        if (itemClickListener!= null){
            chatViewHolder.itemView.setOnClickListener(v -> itemClickListener.onclick(Chat));
        }
    }

    @Override public int getItemCount() {
        return ChatList != null ? ChatList.size() : 0;
    }

    class ChatViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.itemChatTextViewMessage)
        TextView nameTv;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }
    public interface ItemClickListener{
        void onclick(Chat Chat);
    }
}
