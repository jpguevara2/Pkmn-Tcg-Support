package com.example.pkmn_tcg_support;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Menu extends AppCompatActivity {

    ImageButton btnconfiguraciones, btnmanual, btnsalir, btnbatalla;


    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;





        });

        btnconfiguraciones = findViewById(R.id.btnConfiguraciones);
        btnmanual = findViewById(R.id.btnManual);
        btnsalir = findViewById(R.id.btnSalir);
        btnbatalla = findViewById(R.id.btnBatalla);


        btnconfiguraciones.setOnClickListener(v -> {
            Intent i = new Intent(Menu.this, Configuraciones.class);
            startActivity(i);
        });



        btnmanual.setOnClickListener(v -> {
           // Abrir la actividad del manual
         Intent i = new Intent(Menu.this, Manual.class);
           startActivity(i);
        });

        btnsalir.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });

        btnbatalla.setOnClickListener(v -> {
            // Abrir la actividad del manual
            Intent i = new Intent(Menu.this, Batalla.class);
            startActivity(i);
        });



    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.setLocale(newBase, LocaleHelper.getSavedLanguage(newBase)));
    }
}
