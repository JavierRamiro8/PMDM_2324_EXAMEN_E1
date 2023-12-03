package com.example.ejerciciosrepaso;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ejercicio2Retirada extends AppCompatActivity {
public final static String DINEROCUENTARETIRADA ="DINEROCUENTA";

TextView valorRetirarDinero;
Button retirar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2_retirada);
        valorRetirarDinero=findViewById(R.id.ej2ValorRetirada);
        retirar=findViewById(R.id.ej2RetirarDinero);
        Intent i=getIntent();
        Intent enviar=new Intent();
        retirar.setOnClickListener(v ->  {
            String dineroCuentaRetirar=i.getStringExtra(DINEROCUENTARETIRADA);
            int numeroCuenta = Integer.parseInt(dineroCuentaRetirar);
            int numeroRetirar = Integer.parseInt(valorRetirarDinero.getText().toString());
            int resultado = numeroCuenta - numeroRetirar;
            String resultadoString=String.valueOf(resultado);
            enviar.putExtra(ejercicio2Banco.DINEROCUENTA,resultadoString);
            setResult(Activity.RESULT_OK, enviar);
            finish();
        });
    }
}