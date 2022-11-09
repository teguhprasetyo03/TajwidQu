package com.skripsi.aplikasitajwid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.skripsi.aplikasitajwid.hukum_lam.Hukum_Lam;
import com.skripsi.aplikasitajwid.mim_mati.Mim_Mati;
import com.skripsi.aplikasitajwid.nun_mati_tanwin.NunMati_Tanwin;
import com.skripsi.aplikasitajwid.nun_mim_tasyid.Nun_Mim_Tasydid;
import com.skripsi.aplikasitajwid.qalqalah.Qalqalah;

public class MenuTajwid extends AppCompatActivity {
    AppCompatButton btnTanwin,btnMimMati,btnNun,btnLam, btnQalqalah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tajwid);
        btnTanwin = findViewById(R.id.btn_tanwin);
        btnMimMati = findViewById(R.id.btn_mim_mati);
        btnNun = findViewById(R.id.btn_nun);
        btnLam = findViewById(R.id.btn_lam);
        btnQalqalah = findViewById(R.id.btn_qalqalah);

        btnTanwin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuTajwid.this, NunMati_Tanwin.class));
            }
        });

        btnMimMati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuTajwid.this, Mim_Mati.class));
            }
        });

        btnNun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuTajwid.this, Nun_Mim_Tasydid.class));
            }
        });
        btnLam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuTajwid.this, Hukum_Lam.class));
            }
        });

        btnQalqalah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuTajwid.this, Qalqalah.class));
            }
        });

    }

}