package com.itziar.restclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<TrackVo> listTracks;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = (RecyclerView) findViewById(R.id.recyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        listTracks = new ArrayList<>();

        addTrack();

        AdapterDatos adapterDatos = new AdapterDatos(listTracks);
        recycler.setAdapter(adapterDatos);

    }

    private void addTrack() {
        listTracks.add(new TrackVo("Punto40","Canción buena"));
    }
}