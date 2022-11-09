package com.skripsi.aplikasitajwid.nun_mati_tanwin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Ikhfa extends AppCompatActivity {
    private AppCompatButton Play5, Pause5;
    private MediaPlayer mediaPlayer5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikhfa);
        Play5 = findViewById(R.id.play5);
        Pause5 = findViewById(R.id.pause5);


        Play5.setOnClickListener(this::onClick);
        Pause5.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Ikhfa"); // for set actionbar title
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
        Play5.setEnabled(true);
        Pause5.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer5 = MediaPlayer.create(this, R.raw.contoh_ikhfa);

        //Kondisi Button setelah tombol play di klik
        Play5.setEnabled(false);
        Pause5.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer5.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer5.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer5.isPlaying()) {
            if (mediaPlayer5 != null) {
                mediaPlayer5.pause();
                Pause5.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer5 != null) {
                mediaPlayer5.start();
                Pause5.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play5:
                playAudio1();
                break;

            case R.id.pause5:
                pauseAudio1();
                break;
        }
    }
}