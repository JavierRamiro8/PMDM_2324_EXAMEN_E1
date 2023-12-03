package com.example.ejerciciosrepaso;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ejercicio2Ingreso extends AppCompatActivity {
    public final static String DINEROCUENTAINGRESO="DINEROCUENTA";
EditText valorIngreso;
Button ingresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2_ingreso);
        valorIngreso=findViewById(R.id.ej2ValorIngreso);
        ingresar=findViewById(R.id.ej2IngresarDinero);
        Intent i=getIntent();
        Intent enviar=new Intent();
        ingresar.setOnClickListener(v ->  {
            String dineroCuentaRetirar=i.getStringExtra(DINEROCUENTAINGRESO);
            int numeroCuenta = Integer.parseInt(dineroCuentaRetirar);
            int numeroIngresar = Integer.parseInt(valorIngreso.getText().toString());
            int resultado = numeroCuenta + numeroIngresar;
            String resultadoString=String.valueOf(resultado);
            enviar.putExtra(ejercicio2Banco.DINEROCUENTA,resultadoString);
            setResult(Activity.RESULT_OK, enviar);
            finish();
        });
    }
}