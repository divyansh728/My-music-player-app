package com.example.mymusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static com.example.mymusicapp.R.id.btnstop;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton play,pause,stop;
    MediaPlayer mediaPlayer;
    int pauseCurrentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = (ImageButton) findViewById(R.id.btnplay);
        pause = (ImageButton) findViewById(R.id.btnpause);
        stop = (ImageButton) findViewById(btnstop);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnplay:

                if(mediaPlayer==null) {
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.musical);
                mediaPlayer.start(); }
                else if(!mediaPlayer.isPlaying()) {

                    mediaPlayer.start(); }
                else if(!mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(pauseCurrentPosition);
                    mediaPlayer.start();

                }
                break;
            case R.id.btnpause:
                if(mediaPlayer!=null) {
                    mediaPlayer.pause();
                    pauseCurrentPosition = mediaPlayer.getCurrentPosition();
                }

                break;
            case btnstop:
                if(mediaPlayer!=null){
                mediaPlayer.stop();
                mediaPlayer=null; }
                break;

                
        }
    }
}
