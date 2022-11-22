package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Wau extends AppCompatActivity {
    private AppCompatButton Play43, Pause43;
    private MediaPlayer mediaPlayer41;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wau);

        Play43 = findViewById(R.id.play43);
        Pause43 = findViewById(R.id.pause43);


        Play43.setOnClickListener(this::onClick);
        Pause43.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Wawu"); // for set actionbar title
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
        Play43.setEnabled(true);
        Pause43.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer41 = MediaPlayer.create(this, R.raw.waw);

        //Kondisi Button setelah tombol play di klik
        Play43.setEnabled(false);
        Pause43.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer41.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer41.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer41.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer41.isPlaying()) {
            if (mediaPlayer41 != null) {
                mediaPlayer41.pause();
                Pause43.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer41 != null) {
                mediaPlayer41.start();
                Pause43.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play43:
                playAudio1();
                break;

            case R.id.pause43:
                pauseAudio1();
                break;
        }
    }
}