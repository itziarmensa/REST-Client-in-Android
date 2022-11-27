package com.itziar.restclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity1 extends AppCompatActivity {

    ArrayList<TrackVo> listTracks;

    EditText title,desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        listTracks = new ArrayList<>();

        title = findViewById(R.id.addTitle);
        desc = findViewById(R.id.addDesc);

    }

    public void seeList(View view) {
        Intent i = new Intent(MainActivity1.this,MainActivity.class);
        startActivity(i);
    }

    private void addTrack(String title, String desc) {
        listTracks.add(new TrackVo(title,desc));
    }

    public void buttonAddTrack(View view){
        String addTitle = title.getText().toString();
        String addDesc = desc.getText().toString();
        addTrack(addTitle,addDesc);
        Toast.makeText(getApplicationContext(),"Added correctly", Toast.LENGTH_LONG).show();
    }
}