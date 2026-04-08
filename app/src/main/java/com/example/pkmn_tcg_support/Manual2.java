package com.example.pkmn_tcg_support;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class Manual2 extends AppCompatActivity {


    Button btnpagina,btnpagina3;
    ImageButton btnvolver;

    Spinner spestado, spestado2;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_manual2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;





        });

        btnvolver = findViewById(R.id.btnVolver);
        btnpagina = findViewById(R.id.btnPagina1);
        btnpagina3 = findViewById(R.id.btnPagina3);

       spestado = findViewById(R.id.spEstadoM);
       spestado2 = findViewById(R.id.spEstadoM2);

        spestado.setEnabled(false);
        spestado.setClickable(false);
        spestado.setFocusable(false);

        spestado2.setEnabled(false);
        spestado2.setClickable(false);
        spestado2.setFocusable(false);


        // Volver al menú principal
        btnvolver.setOnClickListener(v -> {
            Intent intent = new Intent(Manual2.this, Menu.class);
            startActivity(intent);
            finish();
        });

        // Ir a la página 1
        btnpagina.setOnClickListener(v -> {
            Intent intent = new Intent(Manual2.this, Manual.class);
            startActivity(intent);
            finish();
        });


        // Ir a la página 3
        btnpagina3.setOnClickListener(v -> {
            Intent intent = new Intent(Manual2.this, Manual3.class);
            startActivity(intent);
            finish();
        });




    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.setLocale(newBase, LocaleHelper.getSavedLanguage(newBase)));
    }

}