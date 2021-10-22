package com.example.mymusicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;

public class PlaylistActivity extends AppCompatActivity {

    ListView l;
    int playlist[] = { R.raw.music, R.raw.musical };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        final Field[] fields= R.raw.class.getFields();
        String tutorials[] = new String[fields.length];
        for(int count=0; count < fields.length; count++){
            tutorials[count] = fields[count].getName();
        }

        l = findViewById(R.id.list);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tutorials);
        l.setAdapter(arr);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PlaylistActivity.this, MusicService.class);
                intent.putExtra("musicId", playlist[position]);
                startService(intent);
            }
        });
    }
}
