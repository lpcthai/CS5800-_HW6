package Proxy;

import java.util.ArrayList;
import java.util.List;

public class Song implements SongService {
    private Integer songId;
    private String title;
    private String album;
    private static List<Song> songLibrary = createLibrarySongs();

    public Song() {}

    private Song(Integer songId, String title, String album) {
        this.songId = songId;
        this.title = title;
        this.album = album;
    }

    @Override
    public Song searchById(Integer songId) {
        delay(1000);
        for (Song song : songLibrary) {
            if (song.songId.equals(songId)) {
                return song;
            }
        }
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        delay(1000);
        List<Song> foundSongs = new ArrayList<>();
        for (Song song : songLibrary) {
            if (song.title.equalsIgnoreCase(title)) {
                foundSongs.add(song);
            }
        }
        return foundSongs;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        delay(1000);
        List<Song> foundSongs = new ArrayList<>();
        for (Song song : songLibrary) {
            if (song.album.equalsIgnoreCase(album)) {
                foundSongs.add(song);
            }
        }
        return foundSongs;
    }

    private void delay(int timeDelay) {
        try {
            Thread.sleep(timeDelay);
        } catch (Exception e) {}
    }

    private static List<Song> createLibrarySongs() {
        List<Song> songLibrary = new ArrayList<>();
        songLibrary.add(new Song(1, "Game", "APT by Rose and Bruno Mars"));
        songLibrary.add(new Song(2, "Girl", "Mantra by Jennie"));
        songLibrary.add(new Song(3, "Goodbye", "Bye, and Goodbye by JungWoo" ));
        songLibrary.add(new Song(4, "Get Up", "Super Shy by New Jeans"));
        songLibrary.add(new Song(5, "BabyMonst7er", "Battle Up by Michael Jackson"));
        songLibrary.add(new Song(6, "Born Pink", "Pink Venom by Black Pink"));
        songLibrary.add(new Song(7, "24K Magic", "That's what I like by Bruno Mars"));
        songLibrary.add(new Song(8, "Fearless",  "Story by Taylor Swift"));
        songLibrary.add(new Song(9, "Love Letter" , "Say Yes by SEVENTEENTH"));
        songLibrary.add(new Song(10, "All I Want for Christmas Is You", "Christmas with Mariah Carey by Mariah Carey"));
        return songLibrary;
    }

    @Override
    public String toString() {
        return "Song ID: " + songId + ", Title: " + title + ", Album: " + album;
    }
}
