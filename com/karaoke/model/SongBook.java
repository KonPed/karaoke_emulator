package com.karaoke.model;

import java.util.List;

public class SongBook {
  private List<Song> songs;
  
  
  public SongBook() {
    songs = new ArrayList<Song>();
  } 
  
  public void addSong(Song song) {
    songs.add(song);
  }
  
}