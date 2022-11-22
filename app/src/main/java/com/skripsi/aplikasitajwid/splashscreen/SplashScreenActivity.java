package com.skripsi.aplikasitajwid.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;

import com.skripsi.aplikasitajwid.MainActivity;
import com.skripsi.aplikasitajwid.R;

public class SplashScreenActivity extends AppCompatActivity {

    MediaPlayer mySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);

        mySong=MediaPlayer.create(SplashScreenActivity.this,R.raw.splash);
        mySong.start();
        Thread timer=new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();

                }finally{
                    nextActivity();


                }}} ;

        timer.start();
    }

//        if (SharedPref.getInstance(this).isLoggedUsername()){
//            finishAffinity();
//            startActivity(new Intent(this, Login.class));
//        }

    public void nextActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}