package com.example.ejerciciosrepaso;

import android.app.slice.Slice;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

public class ejercicio4FrCambioColor extends Fragment {

    public ejercicio4FrCambioColor() {
        // Required empty public constructor
    }
    public interface cambioColor{
        void cambioFondoColorDinamico(int r,int g, int b);
    }
    private cambioColor cambioColor;

    private void notifyCambioColor(int r,int g,int b){
        if (cambioColor != null) {
            cambioColor.cambioFondoColorDinamico( r, g, b);
        }
    }
    public void setCambioColor(ejercicio4FrCambioColor.cambioColor observer) {
        this.cambioColor= observer;
    }
    SeekBar dialr,dialb,dialg;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout=inflater.inflate(R.layout.fragment_ejercicio4_fr_cambio_color, container, false);
        dialr=layout.findViewById(R.id.ej3Frdial1);
        dialb=layout.findViewById(R.id.ej3Frdial2);
        dialg=layout.findViewById(R.id.ej3Frdial3);
        dialr.setBackgroundColor(Color.RED);
        dialb.setBackgroundColor(Color.BLUE);
        dialg.setBackgroundColor(Color.GREEN);
        SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                notifyCambioColor(dialr.getProgress(), dialg.getProgress(), dialb.getProgress());
            }
        };
        dialr.setOnSeekBarChangeListener(listener);
        dialg.setOnSeekBarChangeListener(listener);
        dialb.setOnSeekBarChangeListener(listener);
        return layout;
    }
}