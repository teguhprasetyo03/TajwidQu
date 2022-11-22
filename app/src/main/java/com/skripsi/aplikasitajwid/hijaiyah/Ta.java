package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Ta extends AppCompatActivity {
    private AppCompatButton Play18, Pause18;
    private MediaPlayer mediaPlayer16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ta);

        Play18 = findViewById(R.id.play18);
        Pause18 = findViewById(R.id.pause18);


        Play18.setOnClickListener(this::onClick);
        Pause18.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Ta"); // for set actionbar title
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
        Play18.setEnabled(true);
        Pause18.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer16 = MediaPlayer.create(this, R.raw.ta);

        //Kondisi Button setelah tombol play di klik
        Play18.setEnabled(false);
        Pause18.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer16.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer16.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer16.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer16.isPlaying()) {
            if (mediaPlayer16 != null) {
                mediaPlayer16.pause();
                Pause18.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer16 != null) {
                mediaPlayer16.start();
                Pause18.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play18:
                playAudio1();
                break;

            case R.id.pause18:
                pauseAudio1();
                break;
        }
    }
}