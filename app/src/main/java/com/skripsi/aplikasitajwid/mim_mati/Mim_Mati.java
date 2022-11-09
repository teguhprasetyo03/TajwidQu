package com.skripsi.aplikasitajwid.mim_mati;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.skripsi.aplikasitajwid.R;
import com.skripsi.aplikasitajwid.nun_mati_tanwin.Izhar;
import com.skripsi.aplikasitajwid.nun_mati_tanwin.NunMati_Tanwin;

public class Mim_Mati extends AppCompatActivity {
    AppCompatButton btnIkhfa_Syafawi, btnIdgham_Mislain, btnIzhar_Syafawi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mim__mati);
        btnIkhfa_Syafawi = findViewById(R.id.btn_ikhfa_syafawi);
        btnIdgham_Mislain = findViewById(R.id.btn_idgham_mislain);
        btnIzhar_Syafawi = findViewById(R.id.btn_izhar_syafawi);

        btnIkhfa_Syafawi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mim_Mati.this, Ikhfa_Syafawi.class));
            }
        });

        btnIdgham_Mislain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mim_Mati.this, Idgham_Mislain.class));
            }
        });

        btnIzhar_Syafawi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mim_Mati.this, Izhar_Syafawi.class));
            }
        });

    }
}