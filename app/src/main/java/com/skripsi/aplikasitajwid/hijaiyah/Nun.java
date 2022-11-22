package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Nun extends AppCompatActivity {
    private AppCompatButton Play42, Pause42;
    private MediaPlayer mediaPlayer40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nun);


        Play42 = findViewById(R.id.play42);
        Pause42 = findViewById(R.id.pause42);


        Play42.setOnClickListener(this::onClick);
        Pause42.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Nun"); // for set actionbar title
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
        Play42.setEnabled(true);
        Pause42.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer40 = MediaPlayer.create(this, R.raw.nun);

        //Kondisi Button setelah tombol play di klik
        Play42.setEnabled(false);
        Pause42.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer40.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer40.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer40.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer40.isPlaying()) {
            if (mediaPlayer40 != null) {
                mediaPlayer40.pause();
                Pause42.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer40 != null) {
                mediaPlayer40.start();
                Pause42.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play42:
                playAudio1();
                break;

            case R.id.pause42:
                pauseAudio1();
                break;
        }
    }
}