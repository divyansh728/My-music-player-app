package com.example.mymusicapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import static com.example.mymusicapp.R.id.btnstop;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton play,pause,stop;
    MediaPlayer mediaPlayer;
    int pauseCurrentPosition;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.play:
                return true;
            case R.id.list:
                Intent intent = new Intent(MainActivity.this, PlaylistActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

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
        Intent intent = new Intent(this, MusicService.class);
        switch (view.getId()) {
            case R.id.btnplay:
                intent.putExtra("musicId", R.raw.music);
                startService(intent);
                break;
            case R.id.btnpause:
                if(mediaPlayer!=null) {
                    mediaPlayer.pause();
                    pauseCurrentPosition = mediaPlayer.getCurrentPosition();
                }
                break;
            case btnstop:
                stopService(new Intent(this, MusicService.class));
                break;
        }
    }
}
