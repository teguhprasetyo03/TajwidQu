package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Fa extends AppCompatActivity {
    private AppCompatButton Play37, Pause37;
    private MediaPlayer mediaPlayer35;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fa);

        Play37 = findViewById(R.id.play37);
        Pause37 = findViewById(R.id.pause37);


        Play37.setOnClickListener(this::onClick);
        Pause37.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Fa'"); // for set actionbar title
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
        Play37.setEnabled(true);
        Pause37.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer35 = MediaPlayer.create(this, R.raw.fa);

        //Kondisi Button setelah tombol play di klik
        Play37.setEnabled(false);
        Pause37.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer35.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer35.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer35.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer35.isPlaying()) {
            if (mediaPlayer35 != null) {
                mediaPlayer35.pause();
                Pause37.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer35 != null) {
                mediaPlayer35.start();
                Pause37.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play37:
                playAudio1();
                break;

            case R.id.pause37:
                pauseAudio1();
                break;
        }
    }
}