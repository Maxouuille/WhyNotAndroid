package com.example.why_not_android.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.why_not_android.R;
import com.example.why_not_android.data.Models.Signup;
import com.example.why_not_android.data.SharedPreferences.SharedPref;
import com.example.why_not_android.data.dto.UserDTO;
import com.example.why_not_android.data.service.UserService;
import com.example.why_not_android.data.service.providers.NetworkProvider;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile extends AppCompatActivity {

    @BindView(R.id.activity_profile_age_textView)
    TextView ageTextView;
    @BindView(R.id.activity_profile_name_textView)
    TextView nameTextView;
    @BindView(R.id.activity_profile_desc_textView)
    TextView descTextView;
    @BindView(R.id.activity_profile_imageView)
    ImageView profileImageView;


    private SharedPreferences sharedPreferences;
    private UserDTO userDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        sharedPreferences = SharedPref.getInstance(this);
        ButterKnife.bind(this);
        getUserinfo();


    }

    private void getUserinfo() {

        UserService userService;
        userService = NetworkProvider.getClient().create(UserService.class);
        String token = sharedPreferences.getString("token", "");
        String email = sharedPreferences.getString("email", "");
        Log.d("test",email);

        Call<UserDTO> userDTOCall = userService.getUser(token, email);
        userDTOCall.enqueue(new Callback<UserDTO>() {
            @Override
            public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {
                if (response.isSuccessful()) {
                    userDTO = response.body();
                    Log.d("test",userDTO.toString());
                    String url = userDTO.getPhoto();
                    nameTextView.setText(userDTO.getUsername());
                    ageTextView.setText(userDTO.getBirthdate());
                    descTextView.setText(userDTO.getBio());
                   // Glide.with(Profile.this).load(url).into(profileImageView);
                } else {
                    try {
                        Log.d("test",token);
                        //Return to MainActivity if the user is no longer connected.
                        Intent intent = new Intent(Profile.this, LoginActivity.class);
                        startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(Call<UserDTO> call, Throwable t) {
                Log.d("Profile", "Impossible de recuperer les infos utilisateur");
            }
        });
    }


}

