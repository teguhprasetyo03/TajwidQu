package com.skripsi.aplikasitajwid.nun_mim_tasyid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Nun_Mim_Tasydid extends AppCompatActivity {
    private AppCompatButton Play10, Pause10;
    private MediaPlayer mediaPlayer10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nun__mim__tasydid);

        Play10 = findViewById(R.id.play10);
        Pause10 = findViewById(R.id.pause10);

        Play10.setOnClickListener(this::onClick);
        Pause10.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Nun dan Mim Tasydid"); // for set actionbar title
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
        Play10.setEnabled(true);
        Pause10.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer10 = MediaPlayer.create(this, R.raw.tasydid);

        //Kondisi Button setelah tombol play di klik
        Play10.setEnabled(false);
        Pause10.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer10.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer10.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer10.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer10.isPlaying()) {
            if (mediaPlayer10 != null) {
                mediaPlayer10.pause();
                Pause10.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer10 != null) {
                mediaPlayer10.start();
                Pause10.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play10:
                playAudio1();
                break;

            case R.id.pause10:
                pauseAudio1();
                break;
        }
    }
}