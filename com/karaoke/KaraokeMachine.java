package com.karaoke;

import com.karaoke.model.Song;
import com.karaoke.model.SongBook;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Queue;

public class KaraokeMachine {
  private SongBook songBook;
  private BufferedReader bf;
  private Map<String, String> menu;
  private Queue<Song> songQueue;
  
  public KaraokeMachine(SongBook songBook) {
    this.songBook = songBook;
    songQueue = new ArrayDeque<Song>();
    bf = new BufferedReader(new InputStreamReader(System.in));
    menu = new HashMap<String, String>();
    menu.put("add", "Add a new song to the song book");
    menu.put("play", "Play the next song in the queue");
    menu.put("choose", "Choose a song to sing!");
    menu.put("quit", "Give up. Exit the program");
  }
  
  private String promptAction() throws IOException {
    System.out.printf("There are %d songs available and %d in the queue. Your option are: %n", songBook.getSongCount(), songQueue.size());
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
          case "choose":
          String artist = promptForArtist();
          Song artistSong = promptSongForArtist(artist);
          songQueue.add(artistSong);
          System.out.printf("You chose: %s %n", artistSong);
          break;
          case "play":
          playNext();
          break;
          case "quit":
          bf.close();
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
  
  private int promptForIndex(List<String> options) throws IOException {
    int counter = 1;
    for(String option : options) {
      System.out.printf("%d.) %s %n", counter, option);
      counter++;
    }
    System.out.print("Your choice:  ");
    String optionAsString = bf.readLine();
    int choice = Integer.parseInt(optionAsString.trim());
    return choice - 1;
  }
  
  private String promptForArtist() throws IOException {
    System.out.println("Available artists:");
    List<String> artists = new ArrayList<String>(songBook.getArtists());
    int index = promptForIndex(artists);
    return artists.get(index);
  }
  
  private Song promptSongForArtist(String artist) throws IOException {
    List<Song> songs = songBook.getSongsForArtist(artist);
    List<String> titles = new ArrayList<String>();
    for(Song song : songs) {
      titles.add(song.getTitle());
    }
    System.out.printf("Available songs for %s %n", artist);
    int index = promptForIndex(titles);
    return songs.get(index);
  }
  
  public void playNext() {
    Song song = songQueue.poll();
    if(song == null) {
      System.out.println("Sorry there are no songs in the queue. Use choose from the menu to add some.");
    } else {
      System.out.printf("%n%n%n Open %s to hear %s by %s %n%n%n", song.getVideoUrl(), song.getTitle(), song.getArtist());
    }
  }
  
}