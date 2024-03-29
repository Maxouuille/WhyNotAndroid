package com.example.why_not_android.views;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.why_not_android.R;
import com.example.why_not_android.data.SharedPreferences.SharedPref;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.drawer_menu_home:
                Intent home = new Intent(MenuActivity.this, Home.class);
                startActivity(home);
                break;
            case R.id.drawer_menu_my_profil:
                Intent profile = new Intent(MenuActivity.this, Profile.class);
                startActivity(profile);
                break;
            case R.id.drawer_menu_event:
                Intent event = new Intent(MenuActivity.this, EventList.class);
                startActivity(event);
                break;
            case R.id.drawer_menu_match:
                Intent match = new Intent(MenuActivity.this, Matchs.class);
                startActivity(match);
                break;
            case R.id.drawer_menu_logout:
                break;
            case R.id.drawer_menu_leave_application:
                finish();
                System.exit(0);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}


