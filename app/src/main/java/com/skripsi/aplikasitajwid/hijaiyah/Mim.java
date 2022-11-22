package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Mim extends AppCompatActivity {
    private AppCompatButton Play41, Pause41;
    private MediaPlayer mediaPlayer39;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mim);

        Play41 = findViewById(R.id.play41);
        Pause41 = findViewById(R.id.pause41);


        Play41.setOnClickListener(this::onClick);
        Pause41.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Mim"); // for set actionbar title
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
        Play41.setEnabled(true);
        Pause41.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer39 = MediaPlayer.create(this, R.raw.mim);

        //Kondisi Button setelah tombol play di klik
        Play41.setEnabled(false);
        Pause41.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer39.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer39.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer39.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer39.isPlaying()) {
            if (mediaPlayer39 != null) {
                mediaPlayer39.pause();
                Pause41.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer39 != null) {
                mediaPlayer39.start();
                Pause41.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play41:
                playAudio1();
                break;

            case R.id.pause41:
                pauseAudio1();
                break;
        }
    }
}