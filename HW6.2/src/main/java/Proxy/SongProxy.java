package Proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class SongProxy implements SongService {
    private SongService songService;
    private Map<Integer, Song> idCache = new HashMap<>();
    private Map<String, List<Song>> titleCache = new HashMap<>();
    private Map<String, List<Song>> albumCache = new HashMap<>();

    private SongService getSongService() {
        if (songService == null) {
            songService = new Song();
        }
        return songService;
    }

    @Override
    public Song searchById(Integer songId) {
        if (idCache.containsKey(songId)) {
            System.out.println("Cache hit for ID: " + songId);
            return idCache.get(songId);
        }
        System.out.println("Fetching from server for ID: " + songId);
        Song song = getSongService().searchById(songId);
        if (song != null) {
            idCache.put(songId, song);
        }
        return song;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        if (titleCache.containsKey(title)) {
            System.out.println("Cache hit for Title: " + title);
            return titleCache.get(title);
        }
        System.out.println("Fetching from server for Title: " + title);
        List<Song> songs = getSongService().searchByTitle(title);
        titleCache.put(title, songs);
        return songs;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if (albumCache.containsKey(album)) {
            System.out.println("Cache hit for Album: " + album);
            return albumCache.get(album);
        }
        System.out.println("Fetching from server for Album: " + album);
        List<Song> songs = getSongService().searchByAlbum(album);
        albumCache.put(album, songs);
        return songs;
    }
}
