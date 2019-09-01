package com.example.why_not_android.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.why_not_android.R;
import com.example.why_not_android.data.Models.Event;
import com.example.why_not_android.data.Models.Match;
import com.example.why_not_android.data.adapter.EventAdapter;
import com.example.why_not_android.data.adapter.MatchAdapter;
import com.example.why_not_android.data.service.providers.NetworkProvider;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Matchs extends AppCompatActivity {

    @BindView(R.id.activity_all_chats_recyclerView)
    RecyclerView matchsRcv;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    private MatchAdapter matchAdapter;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matchs);
        ButterKnife.bind(this);
        initRcv();
        loadData();
    }

    private void initRcv() {
        Log.d("init", "init");
        matchsRcv.setLayoutManager(new LinearLayoutManager(this));
        matchAdapter = new MatchAdapter();
        matchsRcv.setAdapter(matchAdapter);
        matchAdapter.setItemClickListener(new MatchAdapter.ItemClickListener() {
            @Override
            public void onclick(Match match) {
                //todo
                Intent intent = new Intent(Matchs.this, DetailEvent.class);
                intent.putExtra("matchName", match.getName());
                intent.putExtra("matchPic", match.getImageURL());
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        NetworkProvider.getInstance().getMatchs(new NetworkProvider.Listener<List<Match>>() {
            @Override
            public void onSuccess(List<Match> data) {
                matchAdapter.setMatchList(data);
            }

            @Override
            public void onError(Throwable t) {

            }
        });
    }

}
