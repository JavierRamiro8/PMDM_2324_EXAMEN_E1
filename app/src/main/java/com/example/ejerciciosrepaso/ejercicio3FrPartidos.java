package com.example.ejerciciosrepaso;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

// ejercicio3FrPartidos.java
public class ejercicio3FrPartidos extends Fragment {

    private static final int CONTADORMAX = 11;
    public interface PartidoObserver {
        void onPartidoTerminado(int resultado);
    }
    private PartidoObserver partidoObserver;

    public ejercicio3FrPartidos() {
        // Required empty public constructor
    }

    Button equipo1, equipo2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_ejercicio3_fr_partidos, container, false);

        equipo1 = layout.findViewById(R.id.ej3frBtEquipo1);
        equipo2 = layout.findViewById(R.id.ej3frBtEquipo2);

        equipo1.setOnClickListener(v -> {
            int contador = Integer.parseInt(equipo1.getText().toString());
            if (contador == CONTADORMAX) {
                equipo1.setEnabled(false);
                equipo2.setEnabled(false);
                notifyPartidoTerminado(contador);
            } else {
                contador++;
                equipo1.setText(String.valueOf(contador));
            }
        });

        equipo2.setOnClickListener(v -> {
            int contador = Integer.parseInt(equipo2.getText().toString());
            if (contador == CONTADORMAX) {
                equipo1.setEnabled(false);
                equipo2.setEnabled(false);
                notifyPartidoTerminado(contador);
            } else {
                contador++;
                equipo2.setText(String.valueOf(contador));
            }
        });

        return layout;
    }

    private void notifyPartidoTerminado(int resultado) {
        if (partidoObserver != null) {
            partidoObserver.onPartidoTerminado(resultado);
        }
    }

    public void setPartidoObserver(PartidoObserver observer) {
        this.partidoObserver = observer;
    }
}
