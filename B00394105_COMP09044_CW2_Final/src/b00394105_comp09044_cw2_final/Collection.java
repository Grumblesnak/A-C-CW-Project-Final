package b00394105_comp09044_cw2_final;

import java.util.LinkedList;

// Collection is the structure for each node in CollectionList
// collectionName holds a unique name per user, while collectonID is used to identify which collection is which
// userID and songID act as foreign keys which will connect it to users and songs that a collection may hold
// collectionSongs is a linked list made up of the Song Class, used for storing songs in a collecton
public class Collection {
    public String collectionName;
    public Integer collectionID, userID, songID;
    LinkedList<Song> collectionSongs = new LinkedList<>();
    
    // The structure of the collection when created/called in collectionList for creating new collectons
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
