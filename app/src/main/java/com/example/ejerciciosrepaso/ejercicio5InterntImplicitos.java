package com.example.ejerciciosrepaso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.text.InternalTextApi;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class ejercicio5InterntImplicitos extends AppCompatActivity {
    Button llamada, SMS, Canciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio5_internt_implicitos);
        llamada = findViewById(R.id.ej5BtLlamada);

        SMS = findViewById(R.id.ej5BtSMS);

        Canciones = findViewById(R.id.ej5BtCancion);

        llamada.setOnClickListener(v -> {
            /*<intent>
            <action android:name="android.intent.action.DIAL" />
            </intent>*/
            Intent lanzaTelefono = new Intent(Intent.ACTION_DIAL);
            /*Introducir datos para el telefono*/
            Uri uri = Uri.parse("tel:666");
            lanzaTelefono.setData(uri);
            if (lanzaTelefono.resolveActivity(getPackageManager()) != null) {
                startActivity(lanzaTelefono);
            } else {
                llamada.setError("No ha funcionado");
            }
        });
        SMS.setOnClickListener(v -> {
            /*<intent>
            <action android:name="android.intent.action.VIEW"/>
            //<action android:name="android.intent.action.SENDTO"/>
        </intent>*/
            Intent lanzaSMS = new Intent(Intent.ACTION_SENDTO);
            lanzaSMS.setData(Uri.parse("smsto:" + 666));
            lanzaSMS.putExtra("sms_body", "Te veo luego");
            if (getIntent().resolveActivity(getPackageManager()) != null) {
                startActivity(lanzaSMS);
            } else {
                SMS.setError("NADA");
            }
        });
        Canciones.setOnClickListener(v -> {
            /*<intent>
            <action android:name="android.intent.action.WEB_SEARCH" />
        </intent>*/
            Intent lanzaCanciones = new Intent(Intent.ACTION_WEB_SEARCH);

            lanzaCanciones.putExtra(SearchManager.QUERY, "https://youtu.be/xQoC9JlNXM8?si=jyElqzWUEFyt6ax2");
            if (lanzaCanciones.resolveActivity(getPackageManager()) != null) {
                startActivity(lanzaCanciones);
            } else {
                Canciones.setError("NOPE");
            }
        });
    }
}