package com.example.ejerciciosrepaso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;

public class ejercicio4CambioColor extends AppCompatActivity implements ejercicio4FrCambioColor.cambioColor {
    ejercicio4FrCambioColor slideCambioColor;
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio4_cambio_color);
        slideCambioColor = (ejercicio4FrCambioColor) getSupportFragmentManager().findFragmentById(R.id.ej3FrgColor);
        layout=findViewById(R.id.ej3Layout);
        assert slideCambioColor != null;
        slideCambioColor.setCambioColor(this);
    }

    @Override
    public void cambioFondoColorDinamico(int r, int g, int b) {
        layout.setBackgroundColor(Color.rgb(r,g,b));
    }
}