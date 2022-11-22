package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class To extends AppCompatActivity {
    private AppCompatButton Play33, Pause33;
    private MediaPlayer mediaPlayer31;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to);

        Play33 = findViewById(R.id.play33);
        Pause33 = findViewById(R.id.pause33);


        Play33.setOnClickListener(this::onClick);
        Pause33.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Tho'"); // for set actionbar title
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
        Play33.setEnabled(true);
        Pause33.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer31 = MediaPlayer.create(this, R.raw.tha);

        //Kondisi Button setelah tombol play di klik
        Play33.setEnabled(false);
        Pause33.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer31.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer31.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer31.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer31.isPlaying()) {
            if (mediaPlayer31 != null) {
                mediaPlayer31.pause();
                Pause33.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer31 != null) {
                mediaPlayer31.start();
                Pause33.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play33:
                playAudio1();
                break;

            case R.id.pause33:
                pauseAudio1();
                break;
        }
    }
}