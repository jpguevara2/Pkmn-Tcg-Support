package com.example.pkmn_tcg_support;

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

public class Manual3 extends AppCompatActivity {

    Button btn2;
    ImageButton btnvolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_manual3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        btnvolver = findViewById(R.id.btnVolver);
        btn2 =findViewById(R.id.btnPagina2);

        // Volver al menú principal
        btnvolver.setOnClickListener(v -> {
            Intent intent = new Intent(Manual3.this, Menu.class);
            startActivity(intent);
            finish();
        });

        // Ir a la página 1
        btn2.setOnClickListener(v -> {
            Intent intent = new Intent(Manual3.this, Manual2.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.setLocale(newBase, LocaleHelper.getSavedLanguage(newBase)));
    }
}