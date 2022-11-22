package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Kaf extends AppCompatActivity {
    private AppCompatButton Play39, Pause39;
    private MediaPlayer mediaPlayer37;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaf);

        Play39 = findViewById(R.id.play39);
        Pause39 = findViewById(R.id.pause39);


        Play39.setOnClickListener(this::onClick);
        Pause39.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Kaf"); // for set actionbar title
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
        Play39.setEnabled(true);
        Pause39.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer37 = MediaPlayer.create(this, R.raw.kaf);

        //Kondisi Button setelah tombol play di klik
        Play39.setEnabled(false);
        Pause39.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer37.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer37.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer37.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer37.isPlaying()) {
            if (mediaPlayer37 != null) {
                mediaPlayer37.pause();
                Pause39.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer37 != null) {
                mediaPlayer37.start();
                Pause39.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play39:
                playAudio1();
                break;

            case R.id.pause39:
                pauseAudio1();
                break;
        }
    }
}