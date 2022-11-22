package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Shod extends AppCompatActivity {
    private AppCompatButton Play31, Pause31;
    private MediaPlayer mediaPlayer29;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shod);

        Play31 = findViewById(R.id.play31);
        Pause31 = findViewById(R.id.pause31);


        Play31.setOnClickListener(this::onClick);
        Pause31.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Shod"); // for set actionbar title
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
        Play31.setEnabled(true);
        Pause31.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer29 = MediaPlayer.create(this, R.raw.sad);

        //Kondisi Button setelah tombol play di klik
        Play31.setEnabled(false);
        Pause31.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer29.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer29.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer29.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer29.isPlaying()) {
            if (mediaPlayer29 != null) {
                mediaPlayer29.pause();
                Pause31.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer29 != null) {
                mediaPlayer29.start();
                Pause31.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play31:
                playAudio1();
                break;

            case R.id.pause31:
                pauseAudio1();
                break;
        }
    }
}