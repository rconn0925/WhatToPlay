package com.rossconnacher.whattoplay;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LoginActivity";
    public RelativeLayout twitchButton;
    public Button guestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        twitchButton = (RelativeLayout)findViewById(R.id.twitchButton);
        twitchButton.setOnClickListener(this);
        guestButton = (Button)findViewById(R.id.guestButton);
        guestButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == twitchButton.getId()){
            //login then go to main activity
            Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
            boolean isGuest = false;
            myIntent.putExtra("isGuest", isGuest);
            LoginActivity.this.startActivity(myIntent);


        } else if(v.getId() == guestButton.getId()){
            Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
            boolean isGuest = true;
            myIntent.putExtra("isGuest", isGuest); //Optional parameters
            LoginActivity.this.startActivity(myIntent);
        }
    }

    public void attemptTwitchLogin(){

    }

}
