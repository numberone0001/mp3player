package com.example.app.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.app.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SongListviewAdapter extends ArrayAdapter<Song> {

    private LayoutInflater inflater;
    private int layout;
    private ArrayList<Song> songList;

    public SongListviewAdapter(Context context, int resource, ArrayList<Song> songs) {
        super(context, resource, songs);
        this.songList = songs;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(this.layout, parent, false);

        TextView nameView = view.findViewById(R.id.songName);
        TextView artistView= view.findViewById(R.id.artist);

        Song song = songList.get(position);

        nameView.setText(song.getName());
        artistView.setText(song.getArtist());

        return view;
    }
}
