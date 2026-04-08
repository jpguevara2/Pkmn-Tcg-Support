package com.example.pkmn_tcg_support;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Configuraciones extends AppCompatActivity {

    // Declarar Switches
    Switch stema, sidioma;

    // Declarar botón
    ImageButton btnvolver;


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.setLocale(newBase, LocaleHelper.getSavedLanguage(newBase)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_configuraciones);


        // Asignar vistas a variables
        stema = findViewById(R.id.switchTema);
        sidioma = findViewById(R.id.switchIdioma);
        btnvolver = findViewById(R.id.btnVolver);

        // Leer preferencias
        SharedPreferences sp = getSharedPreferences("MODE", Context.MODE_PRIVATE);
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);

        // Aplicar estados guardados a los switches
        boolean isNightmodeActive = sp.getBoolean("night", false);
        stema.setChecked(isNightmodeActive);

        boolean estadoSwitchIdioma = prefs.getBoolean("switchIdiomaChecked", false);
        sidioma.setChecked(estadoSwitchIdioma);

        // Cambiar tema
        stema.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = sp.edit();
                AppCompatDelegate.setDefaultNightMode(isChecked ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
                editor.putBoolean("night", isChecked);
                editor.apply();
                recreate(); // Reiniciar actividad para aplicar tema
            }
        });

        // Aquí podrías implementar lógica de cambio de idioma si es necesario
        sidioma.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String langCode = isChecked ? "en" : "es";
                LocaleHelper.saveLanguage(Configuraciones.this, langCode);

                SharedPreferences.Editor spEditor = getSharedPreferences("settings", MODE_PRIVATE).edit();
                spEditor.putBoolean("switchIdiomaChecked", isChecked);
                spEditor.apply();

                recreate(); // Reiniciar actividad para aplicar idioma
            }
        });

        // Volver al menú principal
        btnvolver.setOnClickListener(v -> {
            Intent intent = new Intent(Configuraciones.this, Menu.class);
            startActivity(intent);
            finish(); // Cerrar esta actividad para evitar apilar
        });
    }


}
