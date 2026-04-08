package com.example.pkmn_tcg_support;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Manual extends AppCompatActivity {

    Button btn2;
   ImageButton btnvolver;

   Switch swactivo,swhabilidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_manual);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;



        });

        btnvolver = findViewById(R.id.btnVolver);
        btn2 = findViewById(R.id.btnPagina2);

        swactivo = findViewById(R.id.swActivo);
        swhabilidad = findViewById(R.id.sHabilidad);



        // Volver al menú principal
        btnvolver.setOnClickListener(v -> {
            Intent intent = new Intent(Manual.this, Menu.class);
            startActivity(intent);
            finish();
        });

        // Ir a la página 2
        btn2.setOnClickListener(v -> {
            Intent intent = new Intent(Manual.this, Manual2.class);
            startActivity(intent);
            finish();
        });

        Switch swactivo = findViewById(R.id.swActivo);
        swactivo.setEnabled(false);
        swactivo.setChecked(true);


        Switch swhabilidad = findViewById(R.id.sHabilidad);
        swhabilidad.setEnabled(false);
        swhabilidad.setChecked(true);
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.setLocale(newBase, LocaleHelper.getSavedLanguage(newBase)));
    }


}

