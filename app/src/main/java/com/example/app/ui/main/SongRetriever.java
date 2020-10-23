package com.example.app.ui.main;

import android.media.MediaMetadataRetriever;
import android.os.Environment;

import androidx.annotation.NonNull;

import java.io.File;
import java.util.ArrayList;

public class SongRetriever {
    private final String MEDIA_PATH = Environment.getExternalStorageDirectory().toString() + "/Music/";
    private final int DEFAULT_SIZE = 20;

    @NonNull
    private ArrayList<String> getSongURLList(String path){
        ArrayList<String> fileList = new ArrayList<String>(DEFAULT_SIZE);

        File rootFolder = new File(path);
        File[] files = rootFolder.listFiles();
        if(files == null){
            return fileList;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                fileList.addAll(getSongURLList(file.getAbsolutePath()));
            } else if (file.getName().endsWith(".mp3")) {
                fileList.add(file.getAbsolutePath());
            }
        }
        return fileList;
    }

    public ArrayList<Song> getSongList(){
        ArrayList<String> songURLs = getSongURLList(MEDIA_PATH);
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();

        ArrayList<Song> songList = new ArrayList<Song>(songURLs.size());
        for(String url : songURLs){
            retriever.setDataSource(url);
            Song song = new Song();
            song.setAlbum(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM));
            song.setArtist(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUMARTIST));
            song.setName(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
            song.setDuration(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
            String number = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_CD_TRACK_NUMBER);
            if(number != null){
                song.setNumber(Integer.parseInt(number));
            }
            song.setPath(url);
        }

        return songList;
    }

}
