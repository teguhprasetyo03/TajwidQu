package com.skripsi.aplikasitajwid.nun_mati_tanwin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Izhar extends AppCompatActivity {
    TextView tvTitle, tvDesc;
    ImageView imgContoh, imgHuruf;
    private AppCompatButton Play1, Pause1;
    private MediaPlayer mediaPlayer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izhar);
        tvTitle = findViewById(R.id.izhar_title);
        tvDesc = findViewById(R.id.izhar_desc);
        imgContoh = findViewById(R.id.img_contoh_izhar);
        imgHuruf = findViewById(R.id.img_huruf_izhar);

        Play1 = findViewById(R.id.play1);
        Pause1 = findViewById(R.id.pause1);


        Play1.setOnClickListener(this::onClick);
        Pause1.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Izhar"); // for set actionbar title
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
        Play1.setEnabled(true);
        Pause1.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer1 = MediaPlayer.create(this, R.raw.izhar);

        //Kondisi Button setelah tombol play di klik
        Play1.setEnabled(false);
        Pause1.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer1.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer1.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }


    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer1.isPlaying()) {
            if (mediaPlayer1 != null) {
                mediaPlayer1.pause();
                Pause1.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer1 != null) {
                mediaPlayer1.start();
                Pause1.setText("Pause");
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play1:
                playAudio1();
                break;

            case R.id.pause1:
                pauseAudio1();
                break;
        }
        }
}