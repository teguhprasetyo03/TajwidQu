package com.skripsi.aplikasitajwid.nun_mati_tanwin;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.skripsi.aplikasitajwid.R;

import java.io.IOException;

public class Idgham extends AppCompatActivity {
    private AppCompatButton Play2, Pause2,Play3, Pause3,Play4,Pause4;
    private MediaPlayer mediaPlayer2, mediaPlayer3, mediaPlayer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idgham);

        Play2 = findViewById(R.id.play2);
        Pause2 = findViewById(R.id.pause2);

        Play3 = findViewById(R.id.play3);
        Pause3 = findViewById(R.id.pause3);

        Play4 = findViewById(R.id.play4);
        Pause4 = findViewById(R.id.pause4);

        Play4.setOnClickListener(this::onClick);
        Pause4.setOnClickListener(this::onClick);

        Play3.setOnClickListener(this::onClick);
        Pause3.setOnClickListener(this::onClick);

        Play2.setOnClickListener(this::onClick);
        Pause2.setOnClickListener(this::onClick);
        stateAwal();

        getSupportActionBar().setTitle("Idgham"); // for set actionbar title
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
        Play2.setEnabled(true);
        Pause2.setEnabled(false);

        Play3.setEnabled(true);
        Pause3.setEnabled(false);

        Play4.setEnabled(true);
        Pause4.setEnabled(false);


    }

    //Method untuk memainkan musik
    private void playAudio2() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer2 = MediaPlayer.create(this, R.raw.idgham_bi_la_ghunnah);

        //Kondisi Button setelah tombol play di klik
        Play2.setEnabled(false);
        Pause2.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer2.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer2.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    //Method untuk memainkan musik
    private void playAudio3() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer3 = MediaPlayer.create(this, R.raw.idgham_bi_ghunnah);

        //Kondisi Button setelah tombol play di klik
        Play3.setEnabled(false);
        Pause3.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer3.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer3.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    //Method untuk memainkan musik
    private void playAudio4() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer4 = MediaPlayer.create(this, R.raw.pengecualian);

        //Kondisi Button setelah tombol play di klik
        Play4.setEnabled(false);
        Pause4.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer4.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer4.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    //Method untuk mengentikan musik
    private void pauseAudio2() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer2.isPlaying()) {
            if (mediaPlayer2 != null) {
                mediaPlayer2.pause();
                Pause2.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer2 != null) {
                mediaPlayer2.start();
                Pause2.setText("Pause");
            }
        }

    }

    //Method untuk mengentikan musik
    private void pauseAudio3() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer3.isPlaying()) {
            if (mediaPlayer3 != null) {
                mediaPlayer3.pause();
                Pause3.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer3 != null) {
                mediaPlayer3.start();
                Pause3.setText("Pause");
            }
        }
    }

    //Method untuk mengentikan musik
    private void pauseAudio4() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer4.isPlaying()) {
            if (mediaPlayer4 != null) {
                mediaPlayer4.pause();
                Pause4.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer4 != null) {
                mediaPlayer4.start();
                Pause4.setText("Pause");
            }
        }

    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play2:
                playAudio2();
                break;

            case R.id.pause2:
                pauseAudio2();
                break;
            case R.id.play3:
                playAudio3();
                break;

            case R.id.pause3:
                pauseAudio3();
                break;
            case R.id.play4:
                playAudio4();
                break;

            case R.id.pause4:
                pauseAudio4();
                break;
        }
    }
}