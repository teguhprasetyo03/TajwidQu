package com.skripsi.aplikasitajwid.qalqalah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Qalqalah extends AppCompatActivity {
    private AppCompatButton Play13, Pause13, Pause14,Play14;
    private MediaPlayer mediaPlayer13, mediaPlayer14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qalqalah);

        Play13 = findViewById(R.id.play13);
        Pause13 = findViewById(R.id.pause13);

        Play14 = findViewById(R.id.play14);
        Pause14 = findViewById(R.id.pause14);

        Play13.setOnClickListener(this::onClick);
        Pause13.setOnClickListener(this::onClick);

        Play14.setOnClickListener(this::onClick);
        Pause14.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Qalqalah"); // for set actionbar title
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
        Play13.setEnabled(true);
        Pause13.setEnabled(false);

        Play14.setEnabled(true);
        Pause14.setEnabled(false);

    }

    //Method untuk memainkan musik
    private void playAudio2() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer13 = MediaPlayer.create(this, R.raw.cth_kecil);

        //Kondisi Button setelah tombol play di klik
        Play13.setEnabled(false);
        Pause13.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer13.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer13.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer13.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    //Method untuk memainkan musik
    private void playAudio3() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer14 = MediaPlayer.create(this, R.raw.cth_besar);

        //Kondisi Button setelah tombol play di klik
        Play14.setEnabled(false);
        Pause14.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer14.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer14.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer14.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio2() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer13.isPlaying()) {
            if (mediaPlayer13 != null) {
                mediaPlayer13.pause();
                Pause13.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer13 != null) {
                mediaPlayer13.start();
                Pause13.setText("Pause");
            }
        }

    }

    //Method untuk mengentikan musik
    private void pauseAudio3() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer14.isPlaying()) {
            if (mediaPlayer14 != null) {
                mediaPlayer14.pause();
                Pause14.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer14 != null) {
                mediaPlayer14.start();
                Pause14.setText("Pause");
            }
        }
    }



    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play13:
                playAudio2();
                break;

            case R.id.pause13:
                pauseAudio2();
                break;
            case R.id.play14:
                playAudio3();
                break;

            case R.id.pause14:
                pauseAudio3();
                break;
        }
    }
}