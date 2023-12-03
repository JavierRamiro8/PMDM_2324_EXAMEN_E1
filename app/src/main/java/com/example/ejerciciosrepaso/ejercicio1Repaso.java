package com.example.ejerciciosrepaso;

import static com.example.ejerciciosrepaso.ejercicio1ResultadoCalculadora.NUMERO1;
import static com.example.ejerciciosrepaso.ejercicio1ResultadoCalculadora.NUMERO2;
import static com.example.ejerciciosrepaso.ejercicio1ResultadoCalculadora.OPERACION;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class ejercicio1Repaso extends AppCompatActivity {
    TextView numero1, numero2, resultado;
    Button calcular;
    RadioButton rdSumar, rdRestar, rdMultiplicar, rdDividir;
    public final static String RESULTADO = "RESULTADO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1_repaso);
        numero1 = findViewById(R.id.ej1Nm1);
        numero2 = findViewById(R.id.ej1Nm2);
        calcular = findViewById(R.id.ej1BtCalcular);
        rdSumar = findViewById(R.id.ej1rdSumar);
        rdRestar = findViewById(R.id.ej1rdRestar);
        rdMultiplicar = findViewById(R.id.ej1rdMultiplicar);
        rdDividir = findViewById(R.id.ej1rdDividir);
        resultado = findViewById(R.id.ej1RecibirResultado);
        calcular.setOnClickListener((v) -> {
            Intent i = new Intent(this, ejercicio1ResultadoCalculadora.class);
            if (numero1.getText().toString().isEmpty()) {
                numero1.setError("Introduce algun numero aqui");
            }
            if (numero2.getText().toString().isEmpty()) {
                numero2.setError("Introduce algun numero aqui");
            }
            if (!rdSumar.isChecked() && !rdRestar.isChecked() && !rdMultiplicar.isChecked() && !rdDividir.isChecked()) {
                rdSumar.setError("pincha en algun radio");
                rdRestar.setError("pincha en algun radio");
                rdMultiplicar.setError("pincha en algun radio");
                rdDividir.setError("pincha en algun radio");
            }
            if (rdSumar.isChecked() || rdRestar.isChecked() || rdMultiplicar.isChecked() || rdDividir.isChecked() && !numero2.getText().toString().isEmpty() && !numero1.getText().toString().isEmpty()) {
                i.putExtra(NUMERO1, Integer.parseInt(numero1.getText().toString()));
                i.putExtra(NUMERO2, Integer.parseInt(numero2.getText().toString()));
                if (rdSumar.isChecked()) {
                    i.putExtra(OPERACION, rdSumar.getText().toString());
                } else if (rdRestar.isChecked()) {
                    i.putExtra(OPERACION, rdRestar.getText().toString());
                } else if (rdMultiplicar.isChecked()) {
                    i.putExtra(OPERACION, rdMultiplicar.getText().toString());
                } else {
                    i.putExtra(OPERACION, rdDividir.getText().toString());
                }
                launcher.launch(i);
            }

        });

    }

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent data = result.getData();
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        String resultadoRecibido = data.getStringExtra(RESULTADO);
                        resultado.setText(resultadoRecibido);

                    } else if (result.getResultCode() == Activity.RESULT_FIRST_USER) {
                        numero1.setText("");
                        numero2.setText("");
                    }
                }
            }
    );
}