package com.itziar.restclient;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itziar.restclient.models.Track;

import java.util.List;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolder> {

    private List<Track> listTracks;

    final OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(Track track);
    }


    public AdapterDatos(List<Track> listTracks, OnItemClickListener listener) {
        this.listTracks = listTracks;
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView singer;
        private TextView id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            singer = itemView.findViewById(R.id.singer);
            id = itemView.findViewById(R.id.id);
        }

        void binData(final Track track){
            title.setText(track.getTitle());
            singer.setText(track.getSinger());
            id.setText(track.getId());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(track);
                }
            });
        }

    }

    @NonNull
    @Override //Enlaza el adaptador con la actividad item_list
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list,null,false);

        return new ViewHolder(view);
    }

    @Override //Hace la comunicación entre el adaptador y la clase ViewHolder
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binData(listTracks.get(position));
    }

    @Override
    public int getItemCount() {
        return listTracks.size();
    }


}
