package com.itziar.restclient.retrofit;

import com.itziar.restclient.models.Track;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.converter.gson.GsonConverterFactory;

public interface TrackAPI {

    String URL = "http://localhost:8080/dsaApp/";

    
    @GET("tracks/list/")
    Call<List<Track>> getTracks();


    @POST("tracks/")
    Call<Track> addTrack();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
