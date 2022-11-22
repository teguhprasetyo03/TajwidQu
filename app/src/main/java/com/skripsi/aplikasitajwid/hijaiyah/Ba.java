package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Ba extends AppCompatActivity {
    private AppCompatButton Play17, Pause17;
    private MediaPlayer mediaPlayer15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ba);

        Play17 = findViewById(R.id.play17);
        Pause17 = findViewById(R.id.pause17);


        Play17.setOnClickListener(this::onClick);
        Pause17.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Ba"); // for set actionbar title
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
        Play17.setEnabled(true);
        Pause17.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer15 = MediaPlayer.create(this, R.raw.ba);

        //Kondisi Button setelah tombol play di klik
        Play17.setEnabled(false);
        Pause17.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer15.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer15.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer15.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer15.isPlaying()) {
            if (mediaPlayer15 != null) {
                mediaPlayer15.pause();
                Pause17.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer15 != null) {
                mediaPlayer15.start();
                Pause17.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play17:
                playAudio1();
                break;

            case R.id.pause17:
                pauseAudio1();
                break;
        }
    }
}