package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Tsa extends AppCompatActivity {
    private AppCompatButton Play19, Pause19;
    private MediaPlayer mediaPlayer17;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsa);

        Play19 = findViewById(R.id.play19);
        Pause19 = findViewById(R.id.pause19);


        Play19.setOnClickListener(this::onClick);
        Pause19.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Tsa"); // for set actionbar title
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
        Play19.setEnabled(true);
        Pause19.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer17 = MediaPlayer.create(this, R.raw.tsa);

        //Kondisi Button setelah tombol play di klik
        Play19.setEnabled(false);
        Pause19.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer17.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer17.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer17.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer17.isPlaying()) {
            if (mediaPlayer17 != null) {
                mediaPlayer17.pause();
                Pause19.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer17 != null) {
                mediaPlayer17.start();
                Pause19.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play19:
                playAudio1();
                break;

            case R.id.pause19:
                pauseAudio1();
                break;
        }
    }
}