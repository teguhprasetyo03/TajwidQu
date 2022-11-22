package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Jim extends AppCompatActivity {

    private AppCompatButton Play22, Pause22;
    private MediaPlayer mediaPlayer20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jim);

        Play22 = findViewById(R.id.play22);
        Pause22 = findViewById(R.id.pause22);


        Play22.setOnClickListener(this::onClick);
        Pause22.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Jim"); // for set actionbar title
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
        Play22.setEnabled(true);
        Pause22.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer20 = MediaPlayer.create(this, R.raw.jim);

        //Kondisi Button setelah tombol play di klik
        Play22.setEnabled(false);
        Pause22.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer20.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer20.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer20.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer20.isPlaying()) {
            if (mediaPlayer20 != null) {
                mediaPlayer20.pause();
                Pause22.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer20 != null) {
                mediaPlayer20.start();
                Pause22.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play22:
                playAudio1();
                break;

            case R.id.pause22:
                pauseAudio1();
                break;
        }
    }
}