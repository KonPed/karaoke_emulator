package com.karaoke;

import com.karaoke.model.Song;
import com.karaoke.model.SongBook;
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
    menu.put("add", "Add a new song to the song book");
    menu.put("quit", "Give up. Exit the program");
  }
  
  private String promptAction() throws IOException {
    System.out.printf("There are %d songs available. Your option are: %n", songBook.getSongCount());
    for(Map.Entry<String, String> entry : menu.entrySet()) {
      System.out.printf("%s - %s %n", entry.getKey(), entry.getValue());
    }
    System.out.print("What do you want to do: ");
    String choice = bf.readLine();
    return choice.trim().toLowerCase();
  }
  
  public void run() {
    String choice = "";
    do{
      try {
      choice = promptAction();
        switch(choice) {
          case "add":
          Song song = promptNewSong();
          songBook.addSong(song);
          System.out.printf("%s added!  %n%n", song);
          break;
          case "quit":
          System.out.println("Thanks for playing");
          break;
          default :
          System.out.printf("Unknown choice:  '%s'. Try again. %n%n%n", choice);
        }
      }catch(IOException e) {
        System.out.println("Problem with input");
        e.printStackTrace();
      }
    }while(!choice.equals("quit"));
  }
  
  private Song promptNewSong() throws IOException {
    System.out.print("Enter the artist's name: ");
    String artist = bf.readLine();
    System.out.print("Enter the title: ");
    String title = bf.readLine();
    System.out.print("Enter the video URL: ");
    String videoUrl = bf.readLine();
    return new Song(artist, title, videoUrl);
  }
  
}