package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Syin extends AppCompatActivity {
    private AppCompatButton Play30, Pause30;
    private MediaPlayer mediaPlayer28;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syin);

        Play30 = findViewById(R.id.play30);
        Pause30 = findViewById(R.id.pause30);


        Play30.setOnClickListener(this::onClick);
        Pause30.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Syin"); // for set actionbar title
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
        Play30.setEnabled(true);
        Pause30.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer28 = MediaPlayer.create(this, R.raw.syin);

        //Kondisi Button setelah tombol play di klik
        Play30.setEnabled(false);
        Pause30.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer28.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer28.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer28.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer28.isPlaying()) {
            if (mediaPlayer28 != null) {
                mediaPlayer28.pause();
                Pause30.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer28 != null) {
                mediaPlayer28.start();
                Pause30.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play30:
                playAudio1();
                break;

            case R.id.pause30:
                pauseAudio1();
                break;
        }
    }
}