package com.itziar.restclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<TrackVo> listTracks;
    RecyclerView recycler;

    Button btnAdd, btnSee;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = (RecyclerView) findViewById(R.id.recyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        listTracks = new ArrayList<>();

        AdapterDatos adapterDatos = new AdapterDatos(listTracks);
        recycler.setAdapter(adapterDatos);

        btnAdd = findViewById(R.id.addTrack);
        btnSee = findViewById(R.id.seeList);



    }



}