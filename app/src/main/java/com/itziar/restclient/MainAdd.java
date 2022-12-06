package com.itziar.restclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.itziar.restclient.models.Track;

import java.util.ArrayList;

public class MainAdd extends AppCompatActivity {

    ArrayList<Track> listTracks;

    EditText title,desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_main);

        listTracks = new ArrayList<>();

        title = findViewById(R.id.addTitle);
        desc = findViewById(R.id.addDesc);

    }

    public void cancel(View view) {
        Intent i = new Intent(MainAdd.this, MainRecycler.class);
        startActivity(i);
    }

    private void addTrack(String id, String title, String desc) {
        listTracks.add(new Track(id,title,desc));
    }

    /*public void buttonAddTrack(View view){
        String addTitle = title.getText().toString();
        String addDesc = desc.getText().toString();
        addTrack(addTitle,addDesc);
        Toast.makeText(getApplicationContext(),"Added correctly", Toast.LENGTH_LONG).show();
        Intent i = new Intent(MainAdd.this, MainRecycler.class);
        startActivity(i);
    }*/
}