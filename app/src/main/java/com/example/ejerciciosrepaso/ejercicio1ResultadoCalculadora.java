package com.example.ejerciciosrepaso;

import static com.example.ejerciciosrepaso.ejercicio1Repaso.RESULTADO;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ejercicio1ResultadoCalculadora extends AppCompatActivity {
    public final static String NUMERO1 = "LOQUESEA";
    public final static String NUMERO2 = "TAMBIENASI";
    public final static String OPERACION = "OPERACION";
    TextView tvResultado;
    Button reset, volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1_resultado_calculadora);
        tvResultado = findViewById(R.id.ej1IdTvResultado);
        reset = findViewById(R.id.ej1BtReiniciar);
        volver = findViewById(R.id.ej1BtVolver);
        Intent recibir = getIntent();
        Intent enviar = new Intent();
        int numero1Recibido = recibir.getIntExtra(NUMERO1, 0);
        int numero2Recibido = recibir.getIntExtra(NUMERO2, 0);
        String operacion =recibir.getStringExtra(OPERACION);
        int resultado = 0;
        switch (operacion) {
            case "Sumar":
                resultado = numero1Recibido + numero2Recibido;
                tvResultado.setText(String.valueOf(resultado));
                break;
            case "Restar":
                resultado = numero1Recibido - numero2Recibido;
                tvResultado.setText(String.valueOf(resultado));
                break;
            case "Multiplicar":
                resultado = numero1Recibido * numero2Recibido;
                tvResultado.setText(String.valueOf(resultado));
                break;
            case "Dividir":
                if (numero1Recibido ==1 &&numero2Recibido == 0) {
                    tvResultado.setText("No es posible dividir entre 0");

                } else if (numero1Recibido == 0 && numero2Recibido == 1) {
                    tvResultado.setText("No se puede hacer esta division");
                } else {
                    resultado = numero1Recibido / numero2Recibido;
                    tvResultado.setText(String.valueOf(resultado));
                }
                break;
        }
        enviar.putExtra(RESULTADO,tvResultado.getText().toString());
        volver.setOnClickListener(v -> {
            setResult(Activity.RESULT_OK, enviar);
            finish();
        });
        reset.setOnClickListener(v -> {
            setResult(Activity.RESULT_FIRST_USER, enviar);
            finish();
        });
    }
}