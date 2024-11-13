package Proxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SongTest {

    private SongService songService;

    @BeforeEach
    public void setUp() {
        songService = new Song();
    }

    @Test
    public void testSearchById() {
        System.out.println("Test: searchById");
        Song song = songService.searchById(2);
        assertNotNull(song);
        assertEquals("Song ID: 2, Title: Girl, Album: Mantra by Jennie", song.toString());
        Song notFoundSong = songService.searchById(99);
        assertEquals(null, notFoundSong);
    }

    @Test
    public void testSearchByTitle() {
        System.out.println("Test: searchByTitle");
        List<Song> songs = songService.searchByTitle("Girl");
        assertNotNull(songs);
        assertEquals(1, songs.size());
        assertEquals("Song ID: 2, Title: Girl, Album: Mantra by Jennie", songs.get(0).toString());
        List<Song> emptySongs = songService.searchByTitle("Nonexistent Title");
        assertEquals(0, emptySongs.size());
    }

    @Test
    public void testSearchByAlbum() {
        System.out.println("Test: searchByAlbum");
        List<Song> songs = songService.searchByAlbum("Mantra by Jennie");
        assertNotNull(songs);
        assertEquals(1, songs.size());
        assertEquals("Song ID: 2, Title: Girl, Album: Mantra by Jennie", songs.get(0).toString());
        List<Song> noMatchSongs = songService.searchByAlbum("Nonexistent Album");
        assertEquals(0, noMatchSongs.size());
    }
}
