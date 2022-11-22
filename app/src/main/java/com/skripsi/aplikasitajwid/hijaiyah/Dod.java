package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Dod extends AppCompatActivity {
    private AppCompatButton Play32, Pause32;
    private MediaPlayer mediaPlayer30;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dod);

        Play32 = findViewById(R.id.play32);
        Pause32 = findViewById(R.id.pause32);


        Play32.setOnClickListener(this::onClick);
        Pause32.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Dlod"); // for set actionbar title
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
        Play32.setEnabled(true);
        Pause32.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer30 = MediaPlayer.create(this, R.raw.dad);

        //Kondisi Button setelah tombol play di klik
        Play32.setEnabled(false);
        Pause32.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer30.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer30.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer30.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer30.isPlaying()) {
            if (mediaPlayer30 != null) {
                mediaPlayer30.pause();
                Pause32.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer30 != null) {
                mediaPlayer30.start();
                Pause32.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play32:
                playAudio1();
                break;

            case R.id.pause32:
                pauseAudio1();
                break;
        }
    }
}