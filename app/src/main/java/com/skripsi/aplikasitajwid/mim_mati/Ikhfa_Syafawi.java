package com.skripsi.aplikasitajwid.mim_mati;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Ikhfa_Syafawi extends AppCompatActivity {
    private AppCompatButton Play7, Pause7;
    private MediaPlayer mediaPlayer7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikhfa__syafawi);

        Play7 = findViewById(R.id.play7);
        Pause7 = findViewById(R.id.pause7);


        Play7.setOnClickListener(this::onClick);
        Pause7.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Ikhfa Syafawi"); // for set actionbar title
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
        Play7.setEnabled(true);
        Pause7.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer7 = MediaPlayer.create(this, R.raw.contoh_ikhfa_syafawi);

        //Kondisi Button setelah tombol play di klik
        Play7.setEnabled(false);
        Pause7.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer7.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer7.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer7.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer7.isPlaying()) {
            if (mediaPlayer7 != null) {
                mediaPlayer7.pause();
                Pause7.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer7 != null) {
                mediaPlayer7.start();
                Pause7.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play7:
                playAudio1();
                break;

            case R.id.pause7:
                pauseAudio1();
                break;
        }
    }
}