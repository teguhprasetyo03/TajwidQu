package com.skripsi.aplikasitajwid.nun_mati_tanwin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Iqlab extends AppCompatActivity {
    private AppCompatButton Play6, Pause6;
    private MediaPlayer mediaPlayer6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iqlab);

        Play6 = findViewById(R.id.play6);
        Pause6 = findViewById(R.id.pause6);


        Play6.setOnClickListener(this::onClick);
        Pause6.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Iqlab"); // for set actionbar title
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
        Play6.setEnabled(true);
        Pause6.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer6 = MediaPlayer.create(this, R.raw.contoh_iqlab);

        //Kondisi Button setelah tombol play di klik
        Play6.setEnabled(false);
        Pause6.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer6.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer6.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer6.isPlaying()) {
            if (mediaPlayer6 != null) {
                mediaPlayer6.pause();
                Pause6.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer6 != null) {
                mediaPlayer6.start();
                Pause6.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play6:
                playAudio1();
                break;

            case R.id.pause6:
                pauseAudio1();
                break;
        }
    }
}