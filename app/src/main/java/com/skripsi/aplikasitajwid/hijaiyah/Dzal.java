package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Dzal extends AppCompatActivity {
    private AppCompatButton Play26, Pause26;
    private MediaPlayer mediaPlayer24;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dzal);

        Play26 = findViewById(R.id.play26);
        Pause26 = findViewById(R.id.pause26);


        Play26.setOnClickListener(this::onClick);
        Pause26.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Dzal"); // for set actionbar title
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
        Play26.setEnabled(true);
        Pause26.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer24 = MediaPlayer.create(this, R.raw.dzal);

        //Kondisi Button setelah tombol play di klik
        Play26.setEnabled(false);
        Pause26.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer24.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer24.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer24.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer24.isPlaying()) {
            if (mediaPlayer24 != null) {
                mediaPlayer24.pause();
                Pause26.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer24 != null) {
                mediaPlayer24.start();
                Pause26.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play26:
                playAudio1();
                break;

            case R.id.pause26:
                pauseAudio1();
                break;
        }
    }
}