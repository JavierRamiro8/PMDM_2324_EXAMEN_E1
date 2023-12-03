package com.example.ejerciciosrepaso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ejercicio3PingPong extends AppCompatActivity implements ejercicio3FrPartidos.PartidoObserver {
ejercicio3FrPartidos partido1,partido2,partido3,partido4;
TextView resultadoPartido1,resultadoPartido2,resultadoPartido3,resultadoPartido4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3_ping_pong);
        partido1 = (ejercicio3FrPartidos) getSupportFragmentManager().findFragmentById(R.id.ej3FrPartido1);
        partido2 = (ejercicio3FrPartidos) getSupportFragmentManager().findFragmentById(R.id.ej3FrPartido2);
        partido3 = (ejercicio3FrPartidos) getSupportFragmentManager().findFragmentById(R.id.ej3FrPartido3);
        partido4 = (ejercicio3FrPartidos) getSupportFragmentManager().findFragmentById(R.id.ej3FrPartido4);
        partido1.setPartidoObserver(this);
        partido2.setPartidoObserver(this);
        partido3.setPartidoObserver(this);
        partido4.setPartidoObserver(this);

        resultadoPartido1 =findViewById(R.id.ej3ResultadoPartido1);
        resultadoPartido2=findViewById(R.id.ej3ResultadoPartido2);
        resultadoPartido3 =findViewById(R.id.ej3ResultadoPartido3);
        resultadoPartido4 =findViewById(R.id.ej3ResultadoPartido4);


    }

    @Override
    public void onPartidoTerminado(int resultado) {
        resultadoPartido1.setText(String.format("%s / %s",partido1.equipo1.getText().toString(),partido1.equipo2.getText().toString()));
        resultadoPartido2.setText(partido2.equipo1.getText().toString()+"/"+partido2.equipo2.getText().toString());
        resultadoPartido3.setText(partido3.equipo1.getText().toString()+"/"+partido3.equipo2.getText().toString());
        resultadoPartido4.setText(partido4.equipo1.getText().toString()+"/"+partido4.equipo2.getText().toString());
    }
}