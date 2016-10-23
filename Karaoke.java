import com.karaoke.model.Song;
import com.karaoke.model.SongBook;

public class Karaoke {
  public static void main(String[] args) {
    System.out.println("********** WELCOME TO KARAOKE GAME **********");
    
    Song song = new Song("Michael Jackson", "Beat It", "https://www.youtube.com/watch?v=T2PAkPp0_bY");
    SongBook songBook = new SongBook();
    System.out.printf("Adding %s %n", song);
    songBook.addSong(song);
    System.out.printf("There are %d songs %n", songBook.getSongCount());
  }
}