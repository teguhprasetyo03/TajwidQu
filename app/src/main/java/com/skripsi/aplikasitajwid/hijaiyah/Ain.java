package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Ain extends AppCompatActivity {
    private AppCompatButton Play35, Pause35;
    private MediaPlayer mediaPlayer33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ain);

        Play35 = findViewById(R.id.play35);
        Pause35 = findViewById(R.id.pause35);


        Play35.setOnClickListener(this::onClick);
        Pause35.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Ain"); // for set actionbar title
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
        Play35.setEnabled(true);
        Pause35.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer33 = MediaPlayer.create(this, R.raw.ain);

        //Kondisi Button setelah tombol play di klik
        Play35.setEnabled(false);
        Pause35.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer33.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer33.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer33.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer33.isPlaying()) {
            if (mediaPlayer33 != null) {
                mediaPlayer33.pause();
                Pause35.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer33 != null) {
                mediaPlayer33.start();
                Pause35.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play35:
                playAudio1();
                break;

            case R.id.pause35:
                pauseAudio1();
                break;
        }
    }
}