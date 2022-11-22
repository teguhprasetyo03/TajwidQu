package com.skripsi.aplikasitajwid.video;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.skripsi.aplikasitajwid.MenuTajwid;
import com.skripsi.aplikasitajwid.R;
import com.skripsi.aplikasitajwid.nun_mati_tanwin.NunMati_Tanwin;

public class Video extends AppCompatActivity {
    AppCompatButton btnHijaiyah,btnTajwid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        btnHijaiyah = findViewById(R.id.btn_huruf_hijaiyah);
        btnTajwid = findViewById(R.id.btn_tajwid);

        btnHijaiyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Video.this, Hijaiyah.class));
            }
        });

        btnTajwid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(Video.this, Tajwi.class));
            }
        });

    }
}