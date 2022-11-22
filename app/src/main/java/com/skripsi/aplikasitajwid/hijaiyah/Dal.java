package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Dal extends AppCompatActivity {
    private AppCompatButton Play25, Pause25;
    private MediaPlayer mediaPlayer23;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dal);

        Play25 = findViewById(R.id.play25);
        Pause25 = findViewById(R.id.pause25);


        Play25.setOnClickListener(this::onClick);
        Pause25.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Dal"); // for set actionbar title
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
        Play25.setEnabled(true);
        Pause25.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer23 = MediaPlayer.create(this, R.raw.dal);

        //Kondisi Button setelah tombol play di klik
        Play25.setEnabled(false);
        Pause25.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer23.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer23.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer23.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer23.isPlaying()) {
            if (mediaPlayer23 != null) {
                mediaPlayer23.pause();
                Pause25.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer23 != null) {
                mediaPlayer23.start();
                Pause25.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play25:
                playAudio1();
                break;

            case R.id.pause25:
                pauseAudio1();
                break;
        }
    }
}