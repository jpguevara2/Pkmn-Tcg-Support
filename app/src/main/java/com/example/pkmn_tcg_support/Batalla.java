package com.example.pkmn_tcg_support;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.AdapterView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class Batalla extends AppCompatActivity {

    TextView txtpokemon1, txthp, txtpokemon2, txthp2, txtpokemon3, txthp3, txtpokemon4, txthp4,
            txtpokemon5,txthp5,txtpokemon6,txthp6,txtpokemon7,txthp7,txtpokemon8,txthp8,txtmoneda;
    Button btnturno, btnhp, btneliminar, btnreiniciar, btnhp2, btneliminar2, btnhp3, btneliminar3,
            btnhp4, btneliminar4,btnhp5, btneliminar5, btnhp6, btneliminar6, btnhp7, btneliminar7,
            btnhp8, btneliminar8;

    ImageButton btnmoneda, btnvolver;

    Spinner spestado, spestado2, spestado3, spestado4,spestado01, spestado02, spestado03, spestado04,
            spestado5,spestado05,spestado6,spestado06,spestado7,spestado07,spestado8,spestado08;
    Switch swactivo, swhabilidad, swactivo2, swhabilidad2, swactivo3, swhabilidad3, swactivo4, swhabilidad4,
    swactivo5, swhabilidad5, swactivo6, swhabilidad6, swactivo7, swhabilidad7, swactivo8, swhabilidad8,
    swenergia, swpartidario;

    //String[] Estado = {"Estado", "PAR", "SLP", "CONF"};

    //String[] Estado2 = {"Estado2", " PSN", "BRN","PSN/BRN"};

    Switch[] switches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_batalla);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        // get the preferences from OS and check the "night" value as soon as we start the app
        SharedPreferences sp = getSharedPreferences("MODE", Context.MODE_PRIVATE);
        boolean isNightmodeActive = sp.getBoolean("night", false);

        // if active, set the night mode to ON
        if(isNightmodeActive) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        Spinner spEstado = findViewById(R.id.spEstado);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.spinner_Estado,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spEstado.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });



        // Inicialización de componentes
        txtpokemon1 = findViewById(R.id.txtPokemon1);
        txthp =  findViewById(R.id.txtHP);
        btnhp =  findViewById(R.id.btnHPm);
        btneliminar = findViewById(R.id.btnEliminar);
        spestado = findViewById(R.id.spEstado);
        spestado01 = findViewById(R.id.spEstado01);
        swactivo = findViewById(R.id.swActivo);
        swhabilidad = findViewById(R.id.sHabilidad);

        txtpokemon2 = findViewById(R.id.txtPokemon2);
        txthp2 = findViewById(R.id.txtHP2);
        btnhp2 = findViewById(R.id.btnHP2);
        btneliminar2 = findViewById(R.id.btnEliminar2);
        spestado2 = findViewById(R.id.spEstado2);
        spestado02 = findViewById(R.id.spEstado02);
        swactivo2 = findViewById(R.id.swActivo2);
        swhabilidad2 = findViewById(R.id.sHabilidad2);

        txtpokemon3 = findViewById(R.id.txtPokemon3);
        txthp3 = findViewById(R.id.txtHP3);
        btnhp3 = findViewById(R.id.btnHP3);
        btneliminar3 = findViewById(R.id.btnEliminar3);
        spestado3 = findViewById(R.id.spEstado3);
        spestado03 = findViewById(R.id.spEstado03);
        swactivo3 = findViewById(R.id.swActivo3);
        swhabilidad3 = findViewById(R.id.sHabilidad3);

        txtpokemon4 = findViewById(R.id.txtPokemon4);
        txthp4 = findViewById(R.id.txtHP4);
        btnhp4 = findViewById(R.id.btnHP4);
        btneliminar4 = findViewById(R.id.btnEliminar4);
        spestado4 = findViewById(R.id.spEstado4);
        spestado04 = findViewById(R.id.spEstado04);
        swactivo4 = findViewById(R.id.swActivo4);
        swhabilidad4 = findViewById(R.id.sHabilidad4);


        txtpokemon5 = findViewById(R.id.txtPokemon5);
        txthp5 = findViewById(R.id.txtHP5);
        btnhp5 = findViewById(R.id.btnHP5);
        btneliminar5 = findViewById(R.id.btnEliminar5);
        spestado5 = findViewById(R.id.spEstado5);
        spestado05 = findViewById(R.id.spEstado05);
        swactivo5 = findViewById(R.id.swActivo5);
        swhabilidad5 = findViewById(R.id.sHabilidad5);


        txtpokemon6 = findViewById(R.id.txtPokemon6);
        txthp6 = findViewById(R.id.txtHP6);
        btnhp6 = findViewById(R.id.btnHP6);
        btneliminar6 = findViewById(R.id.btnEliminar6);
        spestado6 = findViewById(R.id.spEstado6);
        spestado06 = findViewById(R.id.spEstado06);
        swactivo6 = findViewById(R.id.swActivo6);
        swhabilidad6 = findViewById(R.id.sHabilidad6);


        txtpokemon7 = findViewById(R.id.txtPokemon7);
        txthp7 = findViewById(R.id.txtHP7);
        btnhp7 = findViewById(R.id.btnHP7);
        btneliminar7 = findViewById(R.id.btnEliminar8);
        spestado7 = findViewById(R.id.spEstado7);
        spestado07 = findViewById(R.id.spEstado07);
        swactivo7 = findViewById(R.id.swActivo7);
        swhabilidad7 = findViewById(R.id.sHabilidad7);

        txtpokemon8 = findViewById(R.id.txtPokemon8);
        txthp8 = findViewById(R.id.txtHP8);
        btnhp8 = findViewById(R.id.btnHP8);
        btneliminar8 = findViewById(R.id.btnEliminar7);
        spestado8 = findViewById(R.id.spEstado8);
        spestado08 = findViewById(R.id.spEstado08);
        swactivo8 = findViewById(R.id.swActivo8);
        swhabilidad8 = findViewById(R.id.sHabilidad8);


        btnmoneda = findViewById(R.id.btnMoneda);
        txtmoneda = findViewById(R.id.txtMoneda);
        btnvolver = findViewById(R.id.btnVolver);
        btnturno = findViewById(R.id.btnTurno);
        btnreiniciar = findViewById(R.id.btnReiniciar);
        swenergia = findViewById(R.id.swEnergia);
        swpartidario = findViewById(R.id.swPartidario);

        swactivo = findViewById(R.id.swActivo);
        swhabilidad = findViewById(R.id.sHabilidad);

        switches = new Switch[]{swactivo, swactivo2, swactivo3, swactivo4,swactivo5, swactivo6, swactivo7, swactivo8};

        PokemonActivo();

        // Cargar adapter de estados
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this,
                R.array.spinner_Estado,
                android.R.layout.simple_spinner_item
        );

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spestado.setAdapter(adapter1);
        spestado2.setAdapter(adapter1);
        spestado3.setAdapter(adapter1);
        spestado4.setAdapter(adapter1);
        spestado5.setAdapter(adapter1);
        spestado6.setAdapter(adapter1);
        spestado7.setAdapter(adapter1);
        spestado8.setAdapter(adapter1);


        // Cargar adapter de estados
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.spinner_Estado2,
                android.R.layout.simple_spinner_item
        );

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spestado01.setAdapter(adapter2);
        spestado02.setAdapter(adapter2);
        spestado03.setAdapter(adapter2);
        spestado04.setAdapter(adapter2);
        spestado05.setAdapter(adapter2);
        spestado06.setAdapter(adapter2);
        spestado07.setAdapter(adapter2);
        spestado08.setAdapter(adapter2);




        // Configurar cada spinner con colores
        configurarSpinner(spestado);
        configurarSpinner(spestado2);
        configurarSpinner(spestado3);
        configurarSpinner(spestado4);
        configurarSpinner(spestado5);
        configurarSpinner(spestado6);
        configurarSpinner(spestado7);
        configurarSpinner(spestado8);
        configurarSpinner2(spestado01);
        configurarSpinner2(spestado02);
        configurarSpinner2(spestado03);
        configurarSpinner2(spestado04);
        configurarSpinner2(spestado05);
        configurarSpinner2(spestado06);
        configurarSpinner2(spestado07);
        configurarSpinner2(spestado08);



        // Botón para volver al Menu principal
        btnvolver.setOnClickListener(v -> {
            Intent i = new Intent(Batalla.this, Menu.class);
            startActivity(i);
        });

        // Modificar HP con diálogo
        btnhp.setOnClickListener(v -> mostrarDialogoConOpcion(txthp));
        btnhp2.setOnClickListener(v -> mostrarDialogoConOpcion(txthp2));
        btnhp3.setOnClickListener(v -> mostrarDialogoConOpcion(txthp3));
        btnhp4.setOnClickListener(v -> mostrarDialogoConOpcion(txthp4));
        btnhp5.setOnClickListener(v -> mostrarDialogoConOpcion(txthp5));
        btnhp6.setOnClickListener(v -> mostrarDialogoConOpcion(txthp6));
        btnhp7.setOnClickListener(v -> mostrarDialogoConOpcion(txthp7));
        btnhp8.setOnClickListener(v -> mostrarDialogoConOpcion(txthp8));



        // Eliminar Pokémon 1
        btneliminar.setOnClickListener(v -> {
            txtpokemon1.setText("");
            txthp.setText("0");
            spestado.setSelection(0);
            spestado01.setSelection(0);
            swactivo.setChecked(false);
            swhabilidad.setChecked(false);
        });

        // Eliminar Pokémon 2
        btneliminar2.setOnClickListener(v -> {
            txtpokemon2.setText("");
            txthp2.setText("0");
            spestado2.setSelection(0);
            spestado02.setSelection(0);
            swactivo2.setChecked(false);
            swhabilidad2.setChecked(false);
        });

        // Eliminar Pokémon 3
        btneliminar3.setOnClickListener(v -> {
            txtpokemon3.setText("");
            txthp3.setText("0");
            spestado3.setSelection(0);
            spestado03.setSelection(0);
            swactivo3.setChecked(false);
            swhabilidad3.setChecked(false);
        });

        // Eliminar Pokémon 4
        btneliminar4.setOnClickListener(v -> {
            txtpokemon4.setText("");
            txthp4.setText("0");
            spestado4.setSelection(0);
            spestado04.setSelection(0);
            swactivo4.setChecked(false);
            swhabilidad4.setChecked(false);
        });

        // Eliminar Pokémon 5
        btneliminar5.setOnClickListener(v -> {
            txtpokemon5.setText("");
            txthp5.setText("0");
            spestado5.setSelection(0);
            spestado05.setSelection(0);
            swactivo5.setChecked(false);
            swhabilidad5.setChecked(false);
        });

        // Eliminar Pokémon 6
        btneliminar6.setOnClickListener(v -> {
            txtpokemon6.setText("");
            txthp6.setText("0");
            spestado6.setSelection(0);
            spestado06.setSelection(0);
            swactivo6.setChecked(false);
            swhabilidad6.setChecked(false);
        });

        // Eliminar Pokémon 7
        btneliminar7.setOnClickListener(v -> {
            txtpokemon7.setText("");
            txthp7.setText("0");
            spestado7.setSelection(0);
            spestado07.setSelection(0);
            swactivo7.setChecked(false);
            swhabilidad7.setChecked(false);
        });


        // Eliminar Pokémon 8
        btneliminar8.setOnClickListener(v -> {
            txtpokemon8.setText("");
            txthp8.setText("0");
            spestado8.setSelection(0);
            spestado08.setSelection(0);
            swactivo8.setChecked(false);
            swhabilidad8.setChecked(false);
        });


        // Moneda
        btnmoneda.setOnClickListener(v -> {
            txtmoneda.setText(""); // Borra el texto primero

            new Handler().postDelayed(() -> {
                int number = new Random().nextInt(2) + 1;
                String resultado = (number == 1) ? getString(R.string.coin_heads) : getString(R.string.coin_tails);
                txtmoneda.setText(resultado);
            }, 300); // 300 ms de espera
        });

        // Fin de Turno
        btnturno.setOnClickListener(v -> {
            swhabilidad.setChecked(false);
            swhabilidad2.setChecked(false);
            swhabilidad3.setChecked(false);
            swhabilidad4.setChecked(false);
            swhabilidad5.setChecked(false);
            swhabilidad6.setChecked(false);
            swhabilidad7.setChecked(false);
            swhabilidad8.setChecked(false);
            swenergia.setChecked(false);
            swpartidario.setChecked(false);


        });


        // Reiniciar Partida
        btnreiniciar.setOnClickListener(v -> {

            txtmoneda.setText("");
            swenergia.setChecked(false);
            swpartidario.setChecked(false);

            txtpokemon1.setText("");
            spestado.setSelection(0);
            spestado01.setSelection(0);
            txthp.setText("0");
            swactivo.setChecked(false);
            swhabilidad.setChecked(false);


            txtpokemon2.setText("");
            spestado2.setSelection(0);
            spestado02.setSelection(0);
            txthp2.setText("0");
            swactivo2.setChecked(false);
            swhabilidad2.setChecked(false);

            txtpokemon3.setText("");
            spestado3.setSelection(0);
            spestado03.setSelection(0);
            txthp3.setText("0");
            swactivo3.setChecked(false);
            swhabilidad3.setChecked(false);


            txtpokemon4.setText("");
            spestado4.setSelection(0);
            spestado04.setSelection(0);
            txthp4.setText("0");
            swactivo4.setChecked(false);
            swhabilidad4.setChecked(false);


            txtpokemon5.setText("");
            spestado5.setSelection(0);
            spestado05.setSelection(0);
            txthp5.setText("0");
            swactivo5.setChecked(false);
            swhabilidad5.setChecked(false);


            txtpokemon6.setText("");
            spestado6.setSelection(0);
            spestado06.setSelection(0);
            txthp6.setText("0");
            swactivo6.setChecked(false);
            swhabilidad6.setChecked(false);


            txtpokemon7.setText("");
            spestado7.setSelection(0);
            spestado07.setSelection(0);
            txthp7.setText("0");
            swactivo7.setChecked(false);
            swhabilidad7.setChecked(false);

            txtpokemon8.setText("");
            spestado8.setSelection(0);
            spestado08.setSelection(0);
            txthp8.setText("0");
            swactivo8.setChecked(false);
            swhabilidad8.setChecked(false);

        });


    }



    // Configurar color del Spinner según selección
    private void configurarSpinner(Spinner spinner) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, android.view.View view, int position, long id) {
                String seleccion = parent.getItemAtPosition(position).toString();
                int color;

                switch (seleccion) {
                    case "PAR": color = getResources().getColor(android.R.color.holo_orange_light); break;
                    case "SLP": color = getResources().getColor(android.R.color.darker_gray); break;
                    case "CONF": color = getResources().getColor(android.R.color.holo_green_dark); break;
                    //case "PSN/BRN": color = getResources().getColor(android.R.color.holo_purple); break;
                    default: color = getResources().getColor(android.R.color.transparent); break;
                }

                spinner.setBackgroundColor(color);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }


    // Configurar color del Spinner según selección
    private void configurarSpinner2(Spinner spinner) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, android.view.View view, int position, long id) {
                String seleccion = parent.getItemAtPosition(position).toString();
                int color;

                switch (seleccion) {
                    case "PSN": color = getResources().getColor(android.R.color.holo_purple); break;
                    case "BRN": color = getResources().getColor(android.R.color.holo_red_light); break;
                    case "PSN/BRN": color = getResources().getColor(R.color.marker_burn_poison);; break;
                    default: color = getResources().getColor(android.R.color.transparent); break;
                }

                spinner.setBackgroundColor(color);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }




    // 🔢 Mostrar teclado numérico al modificar HP
    private void mostrarDialogoConOpcion(TextView txthp) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.dialog_title_modify_hp));

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        input.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
        input.setHint(R.string.dialog_hint_example);

        builder.setView(input);

        builder.setPositiveButton(getString(R.string.button_add),
                (dialog, which) -> aplicarCambioALP(txthp, input.getText().toString(), true));

        builder.setNegativeButton(getString(R.string.button_subtract),
                (dialog, which) -> aplicarCambioALP(txthp, input.getText().toString(), false));

        builder.setNeutralButton(getString(R.string.button_cancel), null);

        builder.show();
    }

    //
    private void aplicarCambioALP(TextView txtHP, String valorTexto, boolean esSuma) {
        if (!valorTexto.isEmpty()) {
            try {
                int valor = Integer.parseInt(valorTexto);
                if (!esSuma) valor *= -1;

                int valorActual = 0;
                try {
                    valorActual = Integer.parseInt(txtHP.getText().toString());
                } catch (NumberFormatException e) {
                    valorActual = 0;
                }

                int resultado = valorActual + valor;
                if (resultado < 0) resultado = 0;

                animateNumberChange(txtHP, valorActual, resultado);

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    private void animateNumberChange(TextView textView, int from, int to) {

        ValueAnimator animator = ValueAnimator.ofInt(from, to);
        animator.setDuration(400);

        animator.addUpdateListener(animation -> {
            int value = (int) animation.getAnimatedValue();
            textView.setText(String.valueOf(value));
        });

        animator.start();
    }



    // Cambio de Pokemon activo
    private void PokemonActivo() {

        for (Switch sw : switches) {

            sw.setOnCheckedChangeListener((buttonView, isChecked) -> {

                if (isChecked) {

                    for (Switch s : switches) {
                        if (s != sw) {
                            s.setChecked(false);
                        }
                    }

                }

            });

        }
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.setLocale(newBase, LocaleHelper.getSavedLanguage(newBase)));
    }
}



