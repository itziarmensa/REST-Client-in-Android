package com.itziar.restclient;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolder> {

    ArrayList<TrackVo> listTracks;

    public AdapterDatos(ArrayList<TrackVo> listTracks) {
        this.listTracks = listTracks;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Title,description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
        }

    }

    @NonNull
    @Override //Enlaza el adaptador con la actividad item_list
    public AdapterDatos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list,null,false);

        return new ViewHolder(view);
    }

    @Override //Hace la comunicación entre el adaptador y la clase ViewHolder
    public void onBindViewHolder(@NonNull AdapterDatos.ViewHolder holder, int position) {
        holder.Title.setText(listTracks.get(position).getTitle());
        holder.description.setText(listTracks.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return listTracks.size();
    }
}
