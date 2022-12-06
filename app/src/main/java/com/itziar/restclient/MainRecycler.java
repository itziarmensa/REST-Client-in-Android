package com.itziar.restclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.itziar.restclient.models.Track;
import com.itziar.restclient.retrofit.TrackAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRecycler extends AppCompatActivity {

    private List<Track> listTracks;
    private RecyclerView recycler;
    private AdapterDatos adapterDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_main);

        recycler = findViewById(R.id.recyclerId);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        getTracks();

    }


    public void activityAdd(View view){
        Intent i = new Intent(MainRecycler.this, MainAdd.class);
        startActivity(i);
    }

    private void getTracks() {
        TrackAPI service = TrackAPI.retrofit.create(TrackAPI.class);
        Call<List<Track>> call = service.getTracks();

        call.enqueue(new Callback<List<Track>>() {
            @Override
            public void onResponse(Call<List<Track>> call, Response<List<Track>> response) {
                listTracks = response.body();
                adapterDatos = new AdapterDatos(listTracks, new AdapterDatos.OnItemClickListener() {
                    @Override
                    public void onItemClick(Track object) {

                    }
                });
                recycler.setAdapter(adapterDatos);

            }

            @Override
            public void onFailure(Call<List<Track>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

}