package com.karaoke;

import com.karaoke.model.Songbook;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class KaraokeMachine {
  private SongBook songBook;
  private BufferedReader bf;
  private Map<String, String> menu;
  
  public KaraokeMachine(SongBook songBook) {
    this.songBook = songBook;
    bf = new BufferedReader(new InputStreamReader(System.in));
    menu = new HashMap<String, String>();
  }
}