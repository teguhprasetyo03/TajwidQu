package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Ghain extends AppCompatActivity {
    private AppCompatButton Play36, Pause36;
    private MediaPlayer mediaPlayer34;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghain);

        Play36 = findViewById(R.id.play36);
        Pause36 = findViewById(R.id.pause36);


        Play36.setOnClickListener(this::onClick);
        Pause36.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Ghain"); // for set actionbar title
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
        Play36.setEnabled(true);
        Pause36.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer34 = MediaPlayer.create(this, R.raw.ghain);

        //Kondisi Button setelah tombol play di klik
        Play36.setEnabled(false);
        Pause36.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer34.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer34.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer34.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer34.isPlaying()) {
            if (mediaPlayer34 != null) {
                mediaPlayer34.pause();
                Pause36.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer34 != null) {
                mediaPlayer34.start();
                Pause36.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play36:
                playAudio1();
                break;

            case R.id.pause36:
                pauseAudio1();
                break;
        }
    }
}