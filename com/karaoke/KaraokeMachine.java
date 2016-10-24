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
    String choice;
    do{
      try {
      choice = promptAction();
        switch(choice) {
          case "add":
          // TODO: Add a new song
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
  
}