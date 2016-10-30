package com.karaoke.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

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
  
  private Map<String, List<Song>> byArtist() {
    Map<String, List<Song>> byArtist = new HashMap<String, List<Song>>();
    for(Song song : songs) {
      List<Song> artistSongs = byArtist.get(song.getArtist());
      if(artistSongs == null) {
        artistSongs = new ArrayList<Song>();
        byArtist.put(song.getArtist(), artistSongs);
      }
      artistSongs.add(song);
    }
    return byArtist;
  }
  
  public Set<String> getArtists() {
    return byArtist().keySet();
  }
  
  public List<Song> getSongsForArtist(String artist) {
    return byArtist().get(artist);
  }
  
}