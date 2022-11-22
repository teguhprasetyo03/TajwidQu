package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

public class MenuHijaiyah extends AppCompatActivity {
    AppCompatButton btnAlif,btnBa,btnTa,btnTsa, btnJim, btnHa,
                    btnKho, btnDal, btnDzal, btnRo, btnZay, btnSin,
                    btnSyin, btnShod, btnDhod, btnTo, btnZho, btnAin,
                    btnGhain, btnFa,btnQaf, btnKaf, btnLam,btnMim, btnNun,
                    btnWau, btnha, btnya, btnQalqalah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_hijaiyah);

        btnAlif = findViewById(R.id.btn_alif);
        btnBa = findViewById(R.id.btn_ba);
        btnTa = findViewById(R.id.btn_ta);
        btnTsa = findViewById(R.id.btn_tsa);
        btnJim = findViewById(R.id.btn_jim);
        btnHa = findViewById(R.id.btn_ha);
        btnKho = findViewById(R.id.btn_kho);
        btnDal = findViewById(R.id.btn_dal);
        btnDzal = findViewById(R.id.btn_dzal);
        btnRo = findViewById(R.id.btn_ro);
        btnZay = findViewById(R.id.btn_zay);
        btnSin = findViewById(R.id.btn_sin);
        btnSyin = findViewById(R.id.btn_syin);
        btnShod= findViewById(R.id.btn_shod);
        btnDhod = findViewById(R.id.btn_dhod);
        btnTo = findViewById(R.id.btn_tho);
        btnZho = findViewById(R.id.btn_zho);
        btnAin = findViewById(R.id.btn_ain);
        btnGhain = findViewById(R.id.btn_ghain);
        btnFa = findViewById(R.id.btn_fa);
        btnQaf = findViewById(R.id.btn_qof);
        btnKaf = findViewById(R.id.btn_kaf);
        btnLam = findViewById(R.id.btn_lam);
        btnMim = findViewById(R.id.btn_mim);
        btnNun = findViewById(R.id.btn_nun);
        btnWau = findViewById(R.id.btn_waw);
        btnha = findViewById(R.id.btn_haa);
        btnya = findViewById(R.id.btn_ya);

        btnAlif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Alif.class));
            }
        });

        btnBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Ba.class));
            }
        });

        btnTa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Ta.class));
            }
        });

        btnTsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Tsa.class));
            }
        });

        btnJim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Jim.class));
            }
        });

        btnHa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Ha.class));
            }
        });

        btnKho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Kho.class));
            }
        });

        btnDal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Dal.class));
            }
        });

        btnDzal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Dzal.class));
            }
        });

        btnRo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Ro.class));
            }
        });

        btnZay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Zai.class));
            }
        });

        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Sin.class));
            }
        });

        btnSyin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Syin.class));
            }
        });

        btnShod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Shod.class));
            }
        });

        btnDhod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Dod.class));
            }
        });

        btnTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, To.class));
            }
        });

        btnZho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Zo.class));
            }
        });

        btnAin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Ain.class));
            }
        });

        btnGhain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Ghain.class));
            }
        });

        btnFa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Fa.class));
            }
        });

        btnQaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Qaf.class));
            }
        });

        btnKaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Kaf.class));
            }
        });

        btnLam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Lam.class));
            }
        });

        btnMim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Mim.class));
            }
        });

        btnNun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Nun.class));
            }
        });

        btnWau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Wau.class));
            }
        });

        btnha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Haa.class));
            }
        });

        btnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuHijaiyah.this, Ya.class));
            }
        });
    }
}