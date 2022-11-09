package com.skripsi.aplikasitajwid.mim_mati;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Izhar_Syafawi extends AppCompatActivity {
    private AppCompatButton Play9, Pause9;
    private MediaPlayer mediaPlayer9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izhar__syafawi);

        Play9 = findViewById(R.id.play9);
        Pause9 = findViewById(R.id.pause9);


        Play9.setOnClickListener(this::onClick);
        Pause9.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Ikhfa Syafawi"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for add back arrow in action bar
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void stateAwal() {
        Play9.setEnabled(true);
        Pause9.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer9 = MediaPlayer.create(this, R.raw.contoh_izhar_syafawi);

        //Kondisi Button setelah tombol play di klik
        Play9.setEnabled(false);
        Pause9.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer9.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer9.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer9.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer9.isPlaying()) {
            if (mediaPlayer9 != null) {
                mediaPlayer9.pause();
                Pause9.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer9 != null) {
                mediaPlayer9.start();
                Pause9.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play9:
                playAudio1();
                break;

            case R.id.pause9:
                pauseAudio1();
                break;
        }
    }
}