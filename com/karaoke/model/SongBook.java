package com.karaoke.model;

import java.util.List;
import java.util.ArrayList;

public class SongBook {
  private List<Song> songs;
  
  
  public SongBook() {
    songs = new ArrayList<Song>();
  } 
  
  public void addSong(Song song) {
    songs.add(song);
  }
  
  public int getSongCount() {
    return songs.size();
  }
  
  
  
}