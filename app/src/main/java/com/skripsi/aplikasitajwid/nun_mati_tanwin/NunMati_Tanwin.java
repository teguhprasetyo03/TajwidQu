package com.skripsi.aplikasitajwid.nun_mati_tanwin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

public class NunMati_Tanwin extends AppCompatActivity {
    AppCompatButton btnIzhar, btnIdgham, btnIkhfa,btnIqlab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nun_mati__tanwin);
        btnIzhar = findViewById(R.id.btn_izhar);
        btnIdgham = findViewById(R.id.btn_idgham);
        btnIkhfa = findViewById(R.id.btn_ikhfa);
        btnIqlab = findViewById(R.id.btn_iqlab);

        btnIzhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NunMati_Tanwin.this, Izhar.class));
            }
        });

        btnIdgham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NunMati_Tanwin.this, Idgham.class));
            }
        });

        btnIkhfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NunMati_Tanwin.this, Ikhfa.class));
            }
        });

        btnIqlab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NunMati_Tanwin.this, Iqlab.class));
            }
        });

    }

}
