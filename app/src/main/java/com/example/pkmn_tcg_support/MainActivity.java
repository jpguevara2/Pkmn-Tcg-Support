package com.example.pkmn_tcg_support;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {


//Button btnmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        //btnmenu = findViewById(R.id.btnMenu);

            // get the preferences from OS and check the "night" value as soon as we start the app
            SharedPreferences sp = getSharedPreferences("MODE", Context.MODE_PRIVATE);
            boolean isNightmodeActive = sp.getBoolean("night", false);

            // if active, set the night mode to ON
            if(isNightmodeActive) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, Menu.class);
                startActivity(i);
                finish();
            }
        }, 4000);

    }

}




