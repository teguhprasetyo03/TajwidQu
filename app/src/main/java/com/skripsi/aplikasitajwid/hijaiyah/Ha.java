package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Ha extends AppCompatActivity {
    private AppCompatButton Play23, Pause23;
    private MediaPlayer mediaPlayer21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ha);

        Play23 = findViewById(R.id.play23);
        Pause23 = findViewById(R.id.pause23);


        Play23.setOnClickListener(this::onClick);
        Pause23.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Ha'"); // for set actionbar title
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
        Play23.setEnabled(true);
        Pause23.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer21 = MediaPlayer.create(this, R.raw.ha);

        //Kondisi Button setelah tombol play di klik
        Play23.setEnabled(false);
        Pause23.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer21.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer21.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer21.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer21.isPlaying()) {
            if (mediaPlayer21 != null) {
                mediaPlayer21.pause();
                Pause23.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer21 != null) {
                mediaPlayer21.start();
                Pause23.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play23:
                playAudio1();
                break;

            case R.id.pause23:
                pauseAudio1();
                break;
        }
    }
}