import com.karaoke.model.Song;
import com.karaoke.model.SongBook;
import com.karaoke.KaraokeMachine;
import java.io.BufferedReader;

public class Karaoke {
  
  public static void main(String[] args) {
    System.out.println("********** WELCOME TO KARAOKE GAME **********");
    SongBook songBook = new SongBook();
    songBook.importFrom("songs.txt");
    KaraokeMachine machine = new KaraokeMachine(songBook);
    machine.run();
    System.out.println("Saving book...");
    songBook.exportTo("songs.txt");
  }
}