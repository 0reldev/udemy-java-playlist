import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        Song song = this.findSong(title);
        if (song == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> songs) {
        int size = this.songs.size();
        if (trackNumber < size) {
            Song song = this.songs.get(trackNumber - 1);
            if (song != null && songs.indexOf(song) > 0) {
                songs.add(song);
                return true;
            }
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> songs) {
        for (Song song : this.songs) {
            if (song.getTitle().equals(title)) {
                songs.add(song);
                return true;
            }
        }
        return false;
    }
}
