package com.skripsi.aplikasitajwid.hijaiyah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Zai extends AppCompatActivity {

    private AppCompatButton Play28, Pause28;
    private MediaPlayer mediaPlayer26;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zai);

        Play28 = findViewById(R.id.play28);
        Pause28 = findViewById(R.id.pause28);


        Play28.setOnClickListener(this::onClick);
        Pause28.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Za'"); // for set actionbar title
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
        Play28.setEnabled(true);
        Pause28.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer26 = MediaPlayer.create(this, R.raw.zay);

        //Kondisi Button setelah tombol play di klik
        Play28.setEnabled(false);
        Pause28.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer26.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer26.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer26.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer26.isPlaying()) {
            if (mediaPlayer26 != null) {
                mediaPlayer26.pause();
                Pause28.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer26 != null) {
                mediaPlayer26.start();
                Pause28.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play28:
                playAudio1();
                break;

            case R.id.pause28:
                pauseAudio1();
                break;
        }
    }
}