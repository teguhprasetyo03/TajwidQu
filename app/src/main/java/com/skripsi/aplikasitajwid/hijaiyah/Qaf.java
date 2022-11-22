package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Qaf extends AppCompatActivity {

    private AppCompatButton Play38, Pause38;
    private MediaPlayer mediaPlayer36;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qaf);

        Play38 = findViewById(R.id.play38);
        Pause38 = findViewById(R.id.pause38);


        Play38.setOnClickListener(this::onClick);
        Pause38.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Qaf"); // for set actionbar title
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
        Play38.setEnabled(true);
        Pause38.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer36 = MediaPlayer.create(this, R.raw.qaf);

        //Kondisi Button setelah tombol play di klik
        Play38.setEnabled(false);
        Pause38.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer36.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer36.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer36.isPlaying()) {
            if (mediaPlayer36 != null) {
                mediaPlayer36.pause();
                Pause38.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer36 != null) {
                mediaPlayer36.start();
                Pause38.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play38:
                playAudio1();
                break;

            case R.id.pause38:
                pauseAudio1();
                break;
        }
    }
}