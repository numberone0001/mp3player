package com.example.app.ui.main;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.app.R;
import com.google.android.material.snackbar.Snackbar;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SongTab extends Fragment {

    private ArrayList<Song> songList;

    public SongTab(ArrayList<Song> songs) {
        super();
//        Song song = new Song();
//        song.setDuration("3:06");
//        song.setName("Numb");
//        song.setArtist("Linkin Park");
//        songList = new ArrayList<Song>();
//        songList.add(song);
        songList = songs;
    }

    public void setSongList(ArrayList<Song> songs) {
        songList = songs;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.songpage_layout, container, false);
        ListView songListView = view.findViewById(R.id.songListView); //Objects.requireNonNull(getView()).findViewById(R.id.songListView);
        SongListviewAdapter adapter = new SongListviewAdapter(this.getActivity(), R.layout.songlistview_item_layout, songList);
        songListView.setAdapter(adapter);
        Button refreshButton = view.findViewById(R.id.refreshButton);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Objects.requireNonNull(getActivity()).checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1001);
                }
                if (Objects.requireNonNull(getActivity()).checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1234);
                }

                setSongList((new SongRetriever()).getSongList());
            }

        });
        return view;
    }
}
