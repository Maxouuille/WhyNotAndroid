package com.example.why_not_android.data.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.why_not_android.R;
import com.example.why_not_android.data.Models.Match;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchViewHolder> {
    private List<Match> MatchList;
    private MatchAdapter.ItemClickListener itemClickListener;

    public void setMatchList(List<Match> MatchList) {
        this.MatchList = MatchList;
        notifyDataSetChanged();
    }

    public void setItemClickListener(MatchAdapter.ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override public MatchAdapter.MatchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_match, viewGroup, false);
        return new MatchAdapter.MatchViewHolder(view);
    }

    @Override public void onBindViewHolder(@NonNull MatchAdapter.MatchViewHolder MatchViewHolder, int i) {

        Match Match = MatchList.get(i);
        MatchViewHolder.nameTv.setText(Match.getName());

        if (itemClickListener!= null){
            MatchViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onclick(Match);
                }
            });
        }
    }

    @Override public int getItemCount() {
        return MatchList != null ? MatchList.size() : 0;
    }

    class MatchViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.itemMatchTextViewName) TextView nameTv;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }
    public interface ItemClickListener{
        void onclick(Match Match);
    }
}