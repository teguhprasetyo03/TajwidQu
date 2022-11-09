package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.skripsi.aplikasitajwid.MenuTajwid;
import com.skripsi.aplikasitajwid.R;
import com.skripsi.aplikasitajwid.nun_mati_tanwin.NunMati_Tanwin;

public class MenuHijaiyah extends AppCompatActivity {
    AppCompatButton btnAlif,btnBa,btnNun,btnLam, btnQalqalah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_hijaiyah);

        btnAlif = findViewById(R.id.btn_alif);

        btnAlif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Alif.class));
            }
        });
    }
}