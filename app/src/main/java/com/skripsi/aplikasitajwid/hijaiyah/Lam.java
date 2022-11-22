package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Lam extends AppCompatActivity {
    private AppCompatButton Play40, Pause40;
    private MediaPlayer mediaPlayer38;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lam);


        Play40 = findViewById(R.id.play40);
        Pause40 = findViewById(R.id.pause40);


        Play40.setOnClickListener(this::onClick);
        Pause40.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Lam"); // for set actionbar title
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
        Play40.setEnabled(true);
        Pause40.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer38 = MediaPlayer.create(this, R.raw.lam);

        //Kondisi Button setelah tombol play di klik
        Play40.setEnabled(false);
        Pause40.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer38.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer38.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer38.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer38.isPlaying()) {
            if (mediaPlayer38 != null) {
                mediaPlayer38.pause();
                Pause40.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer38 != null) {
                mediaPlayer38.start();
                Pause40.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play40:
                playAudio1();
                break;

            case R.id.pause40:
                pauseAudio1();
                break;
        }
    }
}