package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Haa extends AppCompatActivity {
    private AppCompatButton Play44, Pause44;
    private MediaPlayer mediaPlayer42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haa);

        Play44 = findViewById(R.id.play44);
        Pause44 = findViewById(R.id.pause44);


        Play44.setOnClickListener(this::onClick);
        Pause44.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Ha"); // for set actionbar title
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
        Play44.setEnabled(true);
        Pause44.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer42 = MediaPlayer.create(this, R.raw.ha_tebal);

        //Kondisi Button setelah tombol play di klik
        Play44.setEnabled(false);
        Pause44.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer42.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer42.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer42.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer42.isPlaying()) {
            if (mediaPlayer42 != null) {
                mediaPlayer42.pause();
                Pause44.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer42 != null) {
                mediaPlayer42.start();
                Pause44.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play44:
                playAudio1();
                break;

            case R.id.pause44:
                pauseAudio1();
                break;
        }
    }
}