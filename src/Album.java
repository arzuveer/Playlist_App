import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<songs> song;// only create it so have to allocate some memory in constructor

    public Album(String title, String artist) {
        this.name = title;
        this.artist = artist;
        this.song = new ArrayList<>();// allocated some memory
    }

    public Album() {
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<songs> getSong() {
        return song;
    }

    public void setSong(List<songs> song) {
        this.song = song;
    }

    boolean findSong(String title)
    {
        for(songs s: song)// songs is class and song is arraylist data structure
        {
            if(s.getTitle().equals(title))
                return true;
        }
        return false;
    }
    String addSongToAlbum(String title, double duration)
    {
        if(!findSong(title))
        {
            songs S = new songs(title,duration);// constructor in songs class will initialize it
            song.add(S);
            return "song added";
        }
            return "song already exists:";
    }
    String addSongToPlaylistFromAlbum(String title, List<songs> playList)
    {
        if(findSong(title))
        {
            for(songs s: song)// playlist is of songs type so it needs both title and length
            {
                if(s.getTitle().equals(title))// to add song to playlist searching the song
                    playList.add(s);
                return "song added to your playlist";
            }
        }
        return "song not added to playlist, not present in album";
    }
    // method overloading and trackno is serialno of song in the album
    String addSongToPlaylistFromAlbum(int trackNo ,List<songs> playList)
    {
        int index= trackNo-1;
        if(index >=0 && index <= song.size())
        {
            playList.add(this.song.get(index));
            return "song added by trackno";
        }
        return "invalid track no";
    }
}
