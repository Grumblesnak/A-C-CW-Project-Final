package b00394105_comp09044_cw2_final;

import java.util.LinkedList;
import java.util.ListIterator;

public class CollectionList {
    LinkedList<Collection> collections = new LinkedList<>();
    Integer collectionCount;
    
    public CollectionList(){
        
    }
    
    public Integer getCount(){
        collectionCount = collections.size();
        return collectionCount;
    }
    
    public Integer getCollectionID(String collectionName, Integer userID){
        Integer retrieveCollectionID = null;
        for(int i = 0; i < collections.size(); i++){
            if(collections.get(i).collectionName.equals(collectionName) && collections.get(i).userID.equals(userID)){
                return collections.get(i).collectionID;
            }
        }
        return retrieveCollectionID;
    }
    
    public Collection getCollectionByID(String collectionName, Integer userID){
        Collection retrieveCollectionID = null;
        for(int i = 0; i < collections.size(); i++){
            if(collections.get(i).collectionName.equals(collectionName) && collections.get(i).userID.equals(userID)){
                retrieveCollectionID = collections.get(i);
            }
        }
        return retrieveCollectionID;
    }
    
    public LinkedList<Collection> getCollections(){
        LinkedList<Collection> retrieveAllCollections = collections;
        return retrieveAllCollections;
    }
    
    public void createCollection(String collectionName, Integer collectionID, Integer userID, Integer songID, Song song){
        Collection newCollection = new Collection(collectionName, collectionID, userID, null, song);
        collections.add(newCollection);
    }
    
    public void addSongToCollection(Integer collectionID, Song song){
        for(int i = 0; i < collections.size(); i++){
            if(collections.get(i).collectionID.equals(collectionID)){
                collections.get(i).collectionSongs.add(song);
            }
        }
    }
    
    public void removeSongFromCollection(Integer collectionID, Integer songID, Integer userID){
        for(int i = 0; i < collections.size(); i++){
            if(collections.get(i).collectionID.equals(collectionID)){
                if(collections.get(i).collectionSongs.get(i).songID.equals(songID) && collections.get(i).collectionSongs.get(i).listID.equals(userID)){
                    collections.get(i).collectionSongs.remove(i);
                }
            }
        }
    }
    
    public void deleteCollection(Integer collectionID, Integer userID){
        for(int i = 0; i< collections.size(); i++){
            if(collections.get(i).userID.equals(userID) && collections.get(i).collectionID.equals(collectionID)){
                collections.remove(i);
            }
        }
    }
    
    public boolean checkCollectionName(String collectionName, Integer userID){
        boolean collectionExists = false;
        for(int i = 0; i < collections.size(); i++){
            if(collections.get(i).collectionName.equals(collectionName) && collections.get(i).userID.equals(userID)){
                collectionExists = true;
            }
        }
        return collectionExists;
    }
}
