import Proxy.Song;
import Proxy.SongProxy;
import Proxy.SongService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
public class SongProxyTest {
    private SongService songService;
    @BeforeEach
    public void setUp() {
        songService = new SongProxy();
    }
    @Test
    public void testSearchById_CacheHit() {
        System.out.println("Test: searchById_CacheHit");
        Song song1 = songService.searchById(2);
        Assertions.assertNotNull(song1);
        Assertions.assertEquals("Song ID: 2, Title: Girl, Album: Mantra by Jennie", song1.toString());
        Song cachedSong1 = songService.searchById(2);
        Assertions.assertNotNull(cachedSong1);
        Assertions.assertEquals(song1.toString(), cachedSong1.toString());
    }

    @Test
    public void testSearchByTitle_CacheHit() {
        System.out.println("Test: searchByTitle_CacheHit");
        List<Song> songs1 = songService.searchByTitle("Girl");
        Assertions.assertNotNull(songs1);
        Assertions.assertEquals(1, songs1.size());
        Assertions.assertEquals("Song ID: 2, Title: Girl, Album: Mantra by Jennie", songs1.get(0).toString());
        List<Song> cachedSongs1 = songService.searchByTitle("Girl");
        Assertions.assertNotNull(cachedSongs1);
        Assertions.assertEquals(songs1.toString(), cachedSongs1.toString());
    }
    @Test
    public void testSearchByAlbum_CacheHit() {
        System.out.println("Test: searchByAlbum_CacheHit");
        List<Song> songs1 = songService.searchByAlbum("Mantra by Jennie");
        Assertions.assertNotNull(songs1);
        Assertions.assertEquals(1, songs1.size());
        Assertions.assertEquals("Song ID: 2, Title: Girl, Album: Mantra by Jennie", songs1.get(0).toString());
        List<Song> cachedSongs1 = songService.searchByAlbum("Mantra by Jennie");
        Assertions.assertNotNull(cachedSongs1);
        Assertions.assertEquals(songs1.toString(), cachedSongs1.toString());
    }
}

