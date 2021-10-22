package com.example.mymusicapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        int musicId = R.raw.music;

        Bundle extras = intent.getExtras();
        if (extras != null) {
            musicId = extras.getInt("musicId");
        }

        if (mediaPlayer != null)
            mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(this, musicId);
        mediaPlayer.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null)
            mediaPlayer.stop();
    }
}
