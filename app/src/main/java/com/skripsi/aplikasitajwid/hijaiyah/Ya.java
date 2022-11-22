package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Ya extends AppCompatActivity {
    private AppCompatButton Play45, Pause45;
    private MediaPlayer mediaPlayer43;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ya);

        Play45 = findViewById(R.id.play45);
        Pause45 = findViewById(R.id.pause45);


        Play45.setOnClickListener(this::onClick);
        Pause45.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Ya"); // for set actionbar title
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
        Play45.setEnabled(true);
        Pause45.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer43 = MediaPlayer.create(this, R.raw.ya);

        //Kondisi Button setelah tombol play di klik
        Play45.setEnabled(false);
        Pause45.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer43.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer43.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer43.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer43.isPlaying()) {
            if (mediaPlayer43 != null) {
                mediaPlayer43.pause();
                Pause45.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer43 != null) {
                mediaPlayer43.start();
                Pause45.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play45:
                playAudio1();
                break;

            case R.id.pause45:
                pauseAudio1();
                break;
        }
    }
}