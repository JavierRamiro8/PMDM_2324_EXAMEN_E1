package com.example.ejerciciosrepaso;

import static com.example.ejerciciosrepaso.ejercicio2Ingreso.DINEROCUENTAINGRESO;
import static com.example.ejerciciosrepaso.ejercicio2Retirada.DINEROCUENTARETIRADA;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ejercicio2Banco extends AppCompatActivity {
    public final static String DINEROCUENTA = "DINEROCUENTA";
    TextView dineroCuenta;
    Button ingresar, retirar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2_banco);
        dineroCuenta = findViewById(R.id.ej2ValorDineroCuenta);
        ingresar = findViewById(R.id.ej2RetirarDinero);
        retirar = findViewById(R.id.ej2Retirar);
        Intent ingreso = new Intent(this, ejercicio2Ingreso.class);
        Intent retirada = new Intent(this, ejercicio2Retirada.class);

        ingresar.setOnClickListener(v -> {
            ingreso.putExtra(DINEROCUENTAINGRESO, dineroCuenta.getText().toString());
            launcher.launch(ingreso);
        });
        retirar.setOnClickListener(v -> {
            retirada.putExtra(DINEROCUENTARETIRADA, dineroCuenta.getText().toString());
            launcher.launch(retirada);
        });
    }

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent data = result.getData();
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        String dinero=data.getStringExtra(DINEROCUENTA);
                        dineroCuenta.setText(dinero);
                    }
                }
            }
    );
}