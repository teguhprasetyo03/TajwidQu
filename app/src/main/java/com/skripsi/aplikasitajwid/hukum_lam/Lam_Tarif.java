package com.skripsi.aplikasitajwid.hukum_lam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Lam_Tarif extends AppCompatActivity {
    private AppCompatButton Play20, Pause20, Pause21,Play21;
    private MediaPlayer mediaPlayer18, mediaPlayer19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lam__tarif);

        Play20 = findViewById(R.id.play20);
        Pause20 = findViewById(R.id.pause20);

        Play21 = findViewById(R.id.play21);
        Pause21 = findViewById(R.id.pause21);

        Play20.setOnClickListener(this::onClick);
        Pause20.setOnClickListener(this::onClick);

        Play21.setOnClickListener(this::onClick);
        Pause21.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Lam Ta'rif"); // for set actionbar title
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
        Play20.setEnabled(true);
        Pause20.setEnabled(false);

        Play21.setEnabled(true);
        Pause21.setEnabled(false);

    }

    //Method untuk memainkan musik
    private void playAudio2() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer18 = MediaPlayer.create(this, R.raw.lam_tarif_qomariah);

        //Kondisi Button setelah tombol play di klik
        Play20.setEnabled(false);
        Pause20.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer18.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer18.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer18.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    //Method untuk memainkan musik
    private void playAudio3() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer19 = MediaPlayer.create(this, R.raw.lam_tarif_syamsiah);

        //Kondisi Button setelah tombol play di klik
        Play21.setEnabled(false);
        Pause21.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer19.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer19.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer19.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio2() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer18.isPlaying()) {
            if (mediaPlayer18 != null) {
                mediaPlayer18.pause();
                Pause20.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer18 != null) {
                mediaPlayer18.start();
                Pause20.setText("Pause");
            }
        }

    }

    //Method untuk mengentikan musik
    private void pauseAudio3() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer19.isPlaying()) {
            if (mediaPlayer19 != null) {
                mediaPlayer19.pause();
                Pause21.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer19 != null) {
                mediaPlayer19.start();
                Pause21.setText("Pause");
            }
        }
    }



    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play20:
                playAudio2();
                break;

            case R.id.pause20:
                pauseAudio2();
                break;
            case R.id.play21:
                playAudio3();
                break;

            case R.id.pause21:
                pauseAudio3();
                break;
        }
    }

}