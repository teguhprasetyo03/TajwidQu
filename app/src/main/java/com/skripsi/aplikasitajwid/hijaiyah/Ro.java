package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Ro extends AppCompatActivity {
    private AppCompatButton Play27, Pause27;
    private MediaPlayer mediaPlayer25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ro);

        Play27 = findViewById(R.id.play27);
        Pause27 = findViewById(R.id.pause27);


        Play27.setOnClickListener(this::onClick);
        Pause27.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Ro"); // for set actionbar title
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
        Play27.setEnabled(true);
        Pause27.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer25 = MediaPlayer.create(this, R.raw.ra);

        //Kondisi Button setelah tombol play di klik
        Play27.setEnabled(false);
        Pause27.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer25.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer25.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer25.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer25.isPlaying()) {
            if (mediaPlayer25 != null) {
                mediaPlayer25.pause();
                Pause27.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer25 != null) {
                mediaPlayer25.start();
                Pause27.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play27:
                playAudio1();
                break;

            case R.id.pause27:
                pauseAudio1();
                break;
        }
    }
}