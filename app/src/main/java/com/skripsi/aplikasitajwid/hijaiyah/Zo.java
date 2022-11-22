package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Zo extends AppCompatActivity {
    private AppCompatButton Play34, Pause34;
    private MediaPlayer mediaPlayer32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zo);
        Play34 = findViewById(R.id.play34);
        Pause34 = findViewById(R.id.pause34);


        Play34.setOnClickListener(this::onClick);
        Pause34.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Zho'"); // for set actionbar title
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
        Play34.setEnabled(true);
        Pause34.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer32 = MediaPlayer.create(this, R.raw.dzo);

        //Kondisi Button setelah tombol play di klik
        Play34.setEnabled(false);
        Pause34.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer32.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer32.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer32.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer32.isPlaying()) {
            if (mediaPlayer32 != null) {
                mediaPlayer32.pause();
                Pause34.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer32 != null) {
                mediaPlayer32.start();
                Pause34.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play34:
                playAudio1();
                break;

            case R.id.pause34:
                pauseAudio1();
                break;
        }
    }
}