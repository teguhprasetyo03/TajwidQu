package com.skripsi.aplikasitajwid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.skripsi.aplikasitajwid.hijaiyah.MenuHijaiyah;
import com.skripsi.aplikasitajwid.video.Video;

public class MainActivity extends AppCompatActivity {

    LinearLayout lntajdwid,ln_hijaiyah, ln_video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lntajdwid = findViewById(R.id.ln_tajwid);
        ln_hijaiyah = findViewById(R.id.ln_hijaiyah);
        ln_video = findViewById(R.id.ln_video);

        lntajdwid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MenuTajwid.class));
            }
        });
        ln_hijaiyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MenuHijaiyah.class));
            }
        });

        ln_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Video.class));
            }
        });
    }


}