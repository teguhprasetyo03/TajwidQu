package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Sin extends AppCompatActivity {

    private AppCompatButton Play29, Pause29;
    private MediaPlayer mediaPlayer27;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sin);

        Play29 = findViewById(R.id.play29);
        Pause29 = findViewById(R.id.pause29);


        Play29.setOnClickListener(this::onClick);
        Pause29.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Sin"); // for set actionbar title
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
        Play29.setEnabled(true);
        Pause29.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer27 = MediaPlayer.create(this, R.raw.sin);

        //Kondisi Button setelah tombol play di klik
        Play29.setEnabled(false);
        Pause29.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer27.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer27.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer27.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer27.isPlaying()) {
            if (mediaPlayer27 != null) {
                mediaPlayer27.pause();
                Pause29.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer27 != null) {
                mediaPlayer27.start();
                Pause29.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play29:
                playAudio1();
                break;

            case R.id.pause29:
                pauseAudio1();
                break;
        }
    }
}