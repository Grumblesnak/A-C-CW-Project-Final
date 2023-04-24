package b00394105_comp09044_cw2_final;

import java.util.LinkedList;

// The CollectionList is used to hold multiple elements(playlist collections) that may be input into the program
// collections is made into a linked list that holds the Collection class, which builds the structure of each node
// collectionCount is used to return a value of how many collections there are
public class CollectionList {
    LinkedList<Collection> collections = new LinkedList<>();
    Integer collectionCount;
    
    // Method is used as a constructer between the GUI and Collections, nothing internal needs to happen
    public CollectionList(){
        
    }
    
    // getCount returns the collectionCount from the size of the collections list
    public Integer getCount(){
        collectionCount = collections.size();
        return collectionCount;
    }
    
    // Using an passed input name and userID taken from the PlaylistUI, this method will locate a collection from a specific user
    public Integer getCollectionID(String collectionName, Integer userID){
        Integer retrieveCollectionID = null;
        for(int i = 0; i < collections.size(); i++){
            // For loop goes through all collections and checks if both the input collection name and ID match
            if(collections.get(i).collectionName.equals(collectionName) && collections.get(i).userID.equals(userID)){
                // If they match then the ID of the corresponding collection will be returned
                return collections.get(i).collectionID;
            }
        }
        // Otherwise a null will be returned
        return retrieveCollectionID;
    }
    
    // getCollectionByID functions similarly to getCollectionID, but instead will retrieve a collection based on name and userID
    public Collection getCollectionByID(String collectionName, Integer userID){
        Collection retrieveCollectionID = null;
        for(int i = 0; i < collections.size(); i++){
            // For loop goes through all collections and checks if both the input collection name and ID match
            if(collections.get(i).collectionName.equals(collectionName) && collections.get(i).userID.equals(userID)){
                // If they match then the collection will be returned
                retrieveCollectionID = collections.get(i);
            }
        }
        // Otherwise a null will be returned
        return retrieveCollectionID;
    }
    
    // getCollections will simply return all collections to the called code
    public LinkedList<Collection> getCollections(){
        LinkedList<Collection> retrieveAllCollections = collections;
        return retrieveAllCollections;
    }
    
    // createCollections is called when a new collection is made in the program
    // newCollection will take in the values from the main code and then be added to the collection list
    public void createCollection(String collectionName, Integer collectionID, Integer userID, Integer songID, Song song){
        Collection newCollection = new Collection(collectionName, collectionID, userID, null, song);
        collections.add(newCollection);
    }
    
    // addSongToCollection is used when adding new songs to the song list within the collection list
    public void addSongToCollection(Integer collectionID, Song song){
        for(int i = 0; i < collections.size(); i++){
            // For loop goes through all collections, if the passed collectionID matches the current collectionID...
            if(collections.get(i).collectionID.equals(collectionID)){
                // Then the song will be added to the songs list
                collections.get(i).collectionSongs.add(song);
            }
        }
    }
    
    // Functions similarly to addSongToCollection but will remove songs by the passed information
    public void removeSongFromCollection(Integer collectionID, Integer songID, Integer userID){
        for(int i = 0; i < collections.size(); i++){
            // For loop through all collections, if a collection has the same collectionID as the passed value...
            if(collections.get(i).collectionID.equals(collectionID)){
                // and if the collections current song has a matching songID and userID to the passed values...
                if(collections.get(i).collectionSongs.get(i).songID.equals(songID) && collections.get(i).collectionSongs.get(i).listID.equals(userID)){
                    // Then that song will be removed from the songs list
                    collections.get(i).collectionSongs.remove(i);
                }
            }
        }
    }
    
    // deleteCollection will take in a collectionID and userID from a call
    public void deleteCollection(Integer collectionID, Integer userID){
        for(int i = 0; i< collections.size(); i++){
            // If the current collection has a matching userID and collectionID...
            if(collections.get(i).userID.equals(userID) && collections.get(i).collectionID.equals(collectionID)){
                // Then the collection will be deleted/removed
                collections.remove(i);
            }
        }
    }
    
    // checkCollectionName is used for checking if a collection for specific users actually exists
    // Used either for all functions involving collections to ensure either a unique name or something exists to manipulate
    public boolean checkCollectionName(String collectionName, Integer userID){
        boolean collectionExists = false;
        for(int i = 0; i < collections.size(); i++){
            // If the current collections name and user match the passed values...
            if(collections.get(i).collectionName.equals(collectionName) && collections.get(i).userID.equals(userID)){
                // Then return that the collection exists
                collectionExists = true;
            }
        }
        // Otherwise return false
        return collectionExists;
    }
}
