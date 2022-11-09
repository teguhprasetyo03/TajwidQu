package com.skripsi.aplikasitajwid.hukum_lam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

public class Hukum_Lam extends AppCompatActivity {
    AppCompatButton btn_lam_tarif, btn_al_jalalah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hukum__lam);

        btn_lam_tarif = findViewById(R.id.btn_lam_tarif);
        btn_al_jalalah = findViewById(R.id.btn_al_jalalah);

        btn_lam_tarif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Hukum_Lam.this, Lam_Tarif.class));
            }
        });

        btn_al_jalalah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Hukum_Lam.this, Al_Jalalah.class));
            }
        });
    }

}