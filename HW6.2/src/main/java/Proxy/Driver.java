package Proxy;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        SongService songService = new SongProxy();

        System.out.println("Search by ID            ");
        System.out.println(songService.searchById(2));
        System.out.println(songService.searchById(7));
        System.out.println(songService.searchById(9));

        System.out.println("\nSearch by Title         ");
        List<Song> songsByTitle = songService.searchByTitle("Goodbye");
        songsByTitle.forEach(System.out::println);

        System.out.println("\nSearch by Album        ");
        List<Song> songsByAlbum = songService.searchByAlbum("\"Bye, and Goodbye by JungWoo");
        songsByAlbum.forEach(System.out::println);
    }
}
