package com.skripsi.aplikasitajwid.hukum_lam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Al_Jalalah extends AppCompatActivity {
    private AppCompatButton Play11, Pause12, Pause11,Play12;
    private MediaPlayer mediaPlayer11, mediaPlayer12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al__jalalah);

        Play11 = findViewById(R.id.play11);
        Pause11 = findViewById(R.id.pause11);

        Play12 = findViewById(R.id.play12);
        Pause12 = findViewById(R.id.pause12);

        Play11.setOnClickListener(this::onClick);
        Pause11.setOnClickListener(this::onClick);

        Play12.setOnClickListener(this::onClick);
        Pause12.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Lafaz Al-Jalalah"); // for set actionbar title
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
        Play11.setEnabled(true);
        Pause11.setEnabled(false);

        Play12.setEnabled(true);
        Pause12.setEnabled(false);

    }

    //Method untuk memainkan musik
    private void playAudio2() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer11 = MediaPlayer.create(this, R.raw.badafathah);

        //Kondisi Button setelah tombol play di klik
        Play11.setEnabled(false);
        Pause11.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer11.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer11.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer11.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    //Method untuk memainkan musik
    private void playAudio3() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer12 = MediaPlayer.create(this, R.raw.badakasrah);

        //Kondisi Button setelah tombol play di klik
        Play12.setEnabled(false);
        Pause12.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer12.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer12.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer12.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio2() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer11.isPlaying()) {
            if (mediaPlayer11 != null) {
                mediaPlayer11.pause();
                Pause11.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer11 != null) {
                mediaPlayer11.start();
                Pause11.setText("Pause");
            }
        }

    }

    //Method untuk mengentikan musik
    private void pauseAudio3() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer12.isPlaying()) {
            if (mediaPlayer12 != null) {
                mediaPlayer12.pause();
                Pause12.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer12 != null) {
                mediaPlayer12.start();
                Pause12.setText("Pause");
            }
        }
    }



    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play11:
                playAudio2();
                break;

            case R.id.pause11:
                pauseAudio2();
                break;
            case R.id.play12:
                playAudio3();
                break;

            case R.id.pause12:
                pauseAudio3();
                break;
        }
    }
}