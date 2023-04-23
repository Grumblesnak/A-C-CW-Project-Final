package b00394105_comp09044_cw2_final;

import java.util.LinkedList;

public class Collection {
    public String collectionName;
    public Integer collectionID, userID, songID;
    LinkedList<Song> collectionSongs = new LinkedList<>();
    
    public Collection(String collectionName, Integer collectionID, Integer userID, Integer songID, Song song){
        this.collectionName = collectionName;
        this.collectionID = collectionID;
        this.userID = userID;
        this.songID = songID;
        collectionSongs.add(song);
    }
    

    // Add a song to a collection
    public void AddSong(Song song){       
       collectionSongs.add(song);
    }
}
