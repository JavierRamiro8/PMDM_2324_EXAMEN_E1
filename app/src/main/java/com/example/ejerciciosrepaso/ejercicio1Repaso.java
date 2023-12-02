package com.example.ejerciciosrepaso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class ejercicio1Repaso extends AppCompatActivity {
TextView numero1,numero2;
Button calcular;
RadioButton rdSumar,rdRestar,rdMultiplicar,rdDividir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1_repaso);
        numero1=findViewById(R.id.ej1Nm1);
        numero2=findViewById(R.id.ej1Nm2);
        calcular=findViewById(R.id.ej1BtCalcular);
        rdSumar=findViewById(R.id.ej1rdSumar);
        rdRestar=findViewById(R.id.ej1rdRestar);
        rdMultiplicar=findViewById(R.id.ej1rdMultiplicar);
        rdDividir=findViewById(R.id.ej1rdDividir);
        calcular.setOnClickListener((v)->{
            if(numero1.getText().toString().isEmpty()){
                numero1.setError("Introduce algun numero aqui");
                calcular.setEnabled(false);
            }
            if(numero2.getText().toString().isEmpty()){
                numero2.setError("Introduce algun numero aqui");
                calcular.setEnabled(false);
            }
            if(!rdSumar.isChecked() && !rdRestar.isChecked() && !rdMultiplicar.isChecked() && !rdDividir.isChecked()){
                rdSumar.setError("pincha en algun radio");
                rdRestar.setError("pincha en algun radio");
                rdMultiplicar.setError("pincha en algun radio");
                rdDividir.setError("pincha en algun radio");
            }
            if(rdSumar.isChecked() || rdRestar.isChecked() || rdMultiplicar.isChecked() || rdDividir.isChecked() && !numero2.getText().toString().isEmpty() && !numero1.getText().toString().isEmpty()){
                calcular.setEnabled(true);
                numero1.setText("");
            }
        });
    }
}