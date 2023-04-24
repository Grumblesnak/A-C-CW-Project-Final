package b00394105_comp09044_cw2_final;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

// MusicList class acts as a list of the Song class with each node bearing its structure
// CollectionLis is also called in with singleton for manipulation of collections
// songCount will be used for setting songID's
public class MusicList {
    LinkedList<Song> songs = new LinkedList<>();
    CollectionList collectionList = CollectionListSingleton.getInstance().getCollectionList();
    Integer songCount;
    
    // Method is used as a constructer between the GUI and Songs, nothing internal needs to happen
    public MusicList(){
        
    }
    // addSong will take the passed information from the GUI (first four are inputs, last two are automatic functions)
    // newSong will be made to equal all the new elements then passed into a node in the song list
    public void addSong(String title, String artist, String genre, Integer releaseYear, Integer songID, Integer listID){
        Song newSong = new Song(title, artist, genre, releaseYear, songID, listID);
        songs.add(newSong);
    }
    
    // checkSongTitle will take a passed song title and the users listID
    public boolean checkSongTitle(String title, Integer listID){
        boolean songExists = false;
        for(int i = 0; i < songs.size(); i++){
            // If the current songs name is the same as the input title and is in the current users playlist...
            if(songs.get(i).title.equals(title) && songs.get(i).listID.equals(listID)){
                // Then the song exists
                songExists = true;
            }
        }
        // Otherwise return false
        return songExists;
    }
    
    // checkArtist will function identically to checkSongTitle but for artist
    // In all honesty the both of them could have been merged into one 'checkSongExists', but time is limited to rework currently
    public boolean checkArtist(String artist, Integer listID){
        boolean correctArtist = false;
        for(int i = 0; i < songs.size(); i++){
            if(songs.get(i).artist.equals(artist) && songs.get(i).listID.equals(listID)){
                correctArtist = true;
            }
        }
        // Otherwise return false
        return correctArtist;
    }
    
    // deleteSong will take a passed song title and artist with the current users listID
    // Could replace title and artist with songID, but not enough time
    public void deleteSong(String title, String artist, Integer listID){
        for(int i = 0; i< songs.size(); i++){
            // If the current songs title, artist, and listID all match the passed information...
            if(songs.get(i).title.equals(title) && songs.get(i).artist.equals(artist) && songs.get(i).listID.equals(listID)){
                // Then delete the song from the list
                songs.remove(i);
            }
        }
    }
    
    // updateSong acts similarly to addSong but will instead replace the existing information of a specified song with new values
    public void updateSong(String title, String artist, String genre, Integer releaseYear, Integer listID, Integer songID){
        for(int i = 0; i< songs.size(); i++){
            // If the current songs listID and songID match the passed songs information...
            if(songs.get(i).listID.equals(listID) && songs.get(i).songID.equals(songID)){
                // Replace the current songs elements with the new values passed (except songID, duh)
                songs.get(i).title = title;
                songs.get(i).artist = artist;
                songs.get(i).genre = genre;
                songs.get(i).releaseYear = releaseYear;
            }
        }
    }
    
    // Will return the amount of songs, used for setting up the songID
    public Integer getCount(){
        songCount = songs.size();
        return songCount;
    }
    
    // getSongID will return the songID using the values passed into the method from the GUI
    // Used for identifying songs, this could be used in place of title and artist for other methods, but not enough time
    public Integer getSongID(String title, String artist, Integer listID){
        Integer retrieveSongID = null;
        for(int i = 0; i < songs.size(); i++){
            if(songs.get(i).title.equals(title) && songs.get(i).artist.equals(artist) && songs.get(i).listID.equals(listID)){
                retrieveSongID = songs.get(i).songID;
            }
        }
        return retrieveSongID;
    }
    
    // getSongByID will return a song based on passed values, is used for the collection making when adding songs (and initial creation)
    public Song getSongByID(String title, String artist, Integer listID){
        for(int i = 0; i < songs.size(); i++){
            if(songs.get(i).title.equals(title) && songs.get(i).artist.equals(artist) && songs.get(i).listID.equals(listID)){
                return songs.get(i);
            }
        }
        return null;
    }
    
    // displaySongs will, as advertised, get the songs linked to he currently signed in users ID and prepare them for display
    // Will return it in the structure of the toString in the Song Class
    public LinkedList<Song> displaySongs(Integer listID){
        LinkedList<Song> songsList = new LinkedList<>();
        if(songs != null && songs.size() > 0){
            for (int i = 0; i < songs.size(); i++){
                // Will only get the songs that have the matching passed listID/userID (the same, so whichever can technically be passed)
                if(songs.get(i).listID.equals(listID)){
                    songsList.add(songs.get(i));
                }
            }
        }
        return songsList;
    }
    
    // displayByTitle functions similarly to displaySongs with listID, but also takes in a specification of the title to display by
    // These displayBy methods also double as search algorithsm since you can search for specific values rather than just sequences
    public LinkedList<Song> displayByTitle(String specification, Integer listID){
        LinkedList<Song> displayBySongs = new LinkedList<>();
        if(songs != null && songs.size() > 0){
            for (int i = 0; i < songs.size(); i++){
                // If the current song title contains the specification letter/sequence and matching listID
                // Then those songs will be displayed (Song:Never Fade Away will be displayed if the specification is just the letter N)
                if(songs.get(i).title.contains(specification) && songs.get(i).listID.equals(listID)){
                    displayBySongs.add(songs.get(i));
                }
            }
        }
        return displayBySongs;
    }
    
    // displayByArtist functions similarly to displaySongs with listID, but also takes in a specification of the artist to display by
    public LinkedList<Song> displayByArtist(String specification, Integer listID){
        LinkedList<Song> displayBySongs = new LinkedList<>();
        if(songs != null && songs.size() > 0){
            for (int i = 0; i < songs.size(); i++){
                // If the current song artist contains the specification letter/sequence and matching listID
                if(songs.get(i).artist.contains(specification) && songs.get(i).listID.equals(listID)){
                    displayBySongs.add(songs.get(i));
                }
            }
        }
        return displayBySongs;
    }
    
    // displayByGenre functions similarly to displaySongs with listID, but also takes in a specification of the genre to display by
    public LinkedList<Song> displayByGenre(String specification, Integer listID){
        LinkedList<Song> displayBySongs = new LinkedList<>();
        if(songs != null && songs.size() > 0){
            for (int i = 0; i < songs.size(); i++){
                // If the current song genre contains the specification letter/sequence and matching listID
                if(songs.get(i).genre.contains(specification) && songs.get(i).listID.equals(listID)){
                    displayBySongs.add(songs.get(i));
                }
            }
        }
        return displayBySongs;
    }
    
    // displayByYear functions similarly to displaySongs with listID, but also takes in a specification of the year to display by
    public LinkedList<Song> displayByYear(Integer specification, Integer listID){
        LinkedList<Song> displayBySongs = new LinkedList<>();
        if(songs != null && songs.size() > 0){
            for (int i = 0; i < songs.size(); i++){
                // If the current song year contains the the specified year then it will be displayed
                // Doesn't have .contains like the rest since it seemingly cant be used on integers
                if(songs.get(i).releaseYear.equals(specification) && songs.get(i).listID.equals(listID)){
                    displayBySongs.add(songs.get(i));
                }
            }
        }
        return displayBySongs;
    }
    
    // displayByCollection functions similarly to displaySongs with listID, but also takes in a specification of the collection to display by
    public LinkedList<Song> displayByCollection(String specification, Integer listID, Integer collectionID){
        LinkedList<Song> displayBySongs = new LinkedList<>();
        Set<Song> addedSongs = new HashSet<>();
        if(songs != null && songs.size() > 0){
            for (int i = 0; i < songs.size(); i++){
                if(songs.get(i).listID.equals(listID)){
                    // If the current song matches the users ID then a new collection will be made that calls a method in COllectionList
                    // The method will use the collection name (specification) and ID to only display songs from a collection of the user
                    Collection collection = collectionList.getCollectionByID(specification, listID);
                    if(collection != null){
                        for (int j = 0; j < collection.collectionSongs.size(); j++){
                            var song = collection.collectionSongs.get(j);
                            // song will be used to hold the song element in the list in the collection
                            if(!addedSongs.contains(song)){
                                // addedSongs is used to check if a song is already made for display
                                // Due to originally displaying the same song over and over depending on the amount of songs
                                displayBySongs.add(song);
                                addedSongs.add(song);
                            }
                        }
                    }
                }
            }
        }
        return displayBySongs;
    }
    
    // The following sortBy methods are all examples of bubble sorts
    // Each sortBy also includes new lists for displaying songs and holding songs
    public LinkedList<Song> sortByTitle(String sortChoice, Integer listID){
        LinkedList<Song> displayBySongs = new LinkedList<>();
        LinkedList<Song> songsList = new LinkedList<>();
        
        for(int x = 0; x < songs.size(); x++){
            // Ensures that the songs displayed will be from the currently signed in users playlist
            if(songs.get(x).listID.equals(listID)){
                // All songs wll be added to the songsList list and used for sorting the nodes around
                songsList.addAll(songs);

                // Nested for loop will go through the list and sort the nodes
                int n = songsList.size();
                for(int i = 0; i < n - 1; i++){
                    for(int j = 0; j < n - i - 1; j++){
                        // The inner loop will get the songs found at position j and the position ahead of it
                        // It will then compare the two of them (in this instance their title)
                        Song song1 = songsList.get(j);
                        Song song2 = songsList.get(j + 1);
                        int compareResult = song1.title.compareTo(song2.title);

                        // The code will then check the sortChoice(value from a combo-box) and order the nodes based on either asc or desc
                        // In this instance it will be sorted alphabetically either ascending or descending
                        if(sortChoice.equals("ascending")){
                            if(compareResult > 0){
                                songsList.set(j, song2);
                                songsList.set(j + 1, song1);
                            }
                        } else if(sortChoice.equals("descending")){
                            if(compareResult < 0){
                                songsList.set(j, song2);
                                songsList.set(j + 1, song1);
                            }
                        }
                    }
                }
                // After the loops are finished, the newly created list (either ascending or descending)...
                // is added to the empty displayBySongs list, then returned to the GUI to be displayed
                displayBySongs.addAll(songsList);
            }
        }
        return displayBySongs;
    }
    
    // The rest of the sortBy methods follow the same process, but sort by their specified name (artist, genre, releaseYear)
    public LinkedList<Song> sortByArtist(String sortChoice, Integer listID){
        LinkedList<Song> displayBySongs = new LinkedList<>();
        LinkedList<Song> songsList = new LinkedList<>();
        
        for(int x = 0; x < songs.size(); x++){
            if(songs.get(x).listID.equals(listID)){
                songsList.addAll(songs);

                int n = songsList.size();
                for(int i = 0; i < n - 1; i++){
                    for(int j = 0; j < n - i - 1; j++){
                        Song song1 = songsList.get(j);
                        Song song2 = songsList.get(j + 1);
                        int compareResult = song1.artist.compareTo(song2.artist);

                        if(sortChoice.equals("ascending")){
                            if(compareResult > 0){
                                songsList.set(j, song2);
                                songsList.set(j + 1, song1);
                            }
                        } else if(sortChoice.equals("descending")){
                            if(compareResult < 0){
                                songsList.set(j, song2);
                                songsList.set(j + 1, song1);
                            }
                        }
                    }
                }
                displayBySongs.addAll(songsList);
            }
        }
        return displayBySongs;
    }
    
    public LinkedList<Song> sortByGenre(String sortChoice, Integer listID){
        LinkedList<Song> displayBySongs = new LinkedList<>();
        LinkedList<Song> songsList = new LinkedList<>();
        
        for(int x = 0; x < songs.size(); x++){
            if(songs.get(x).listID.equals(listID)){
                songsList.addAll(songs);

                int n = songsList.size();
                for(int i = 0; i < n - 1; i++){
                    for(int j = 0; j < n - i - 1; j++){
                        Song song1 = songsList.get(j);
                        Song song2 = songsList.get(j + 1);
                        int compareResult = song1.genre.compareTo(song2.genre);

                        if(sortChoice.equals("ascending")){
                            if(compareResult > 0){
                                songsList.set(j, song2);
                                songsList.set(j + 1, song1);
                            }
                        } else if(sortChoice.equals("descending")){
                            if(compareResult < 0){
                                songsList.set(j, song2);
                                songsList.set(j + 1, song1);
                            }
                        }
                    }
                }
                displayBySongs.addAll(songsList);
            }
        }
        return displayBySongs;
    }
    
    public LinkedList<Song> sortByYear(String sortChoice, Integer listID){
        LinkedList<Song> displayBySongs = new LinkedList<>();
        LinkedList<Song> songsList = new LinkedList<>();
        
        for(int x = 0; x < songs.size(); x++){
            if(songs.get(x).listID.equals(listID)){
                songsList.addAll(songs);

                int n = songsList.size();
                for(int i = 0; i < n - 1; i++){
                    for(int j = 0; j < n - i - 1; j++){
                        Song song1 = songsList.get(j);
                        Song song2 = songsList.get(j + 1);
                        int compareResult = song1.releaseYear.compareTo(song2.releaseYear);

                        if(sortChoice.equals("ascending")){
                            if(compareResult > 0){
                                songsList.set(j, song2);
                                songsList.set(j + 1, song1);
                            }
                        } else if(sortChoice.equals("descending")){
                            if(compareResult < 0){
                                songsList.set(j, song2);
                                songsList.set(j + 1, song1);
                            }
                        }
                    }
                }
                displayBySongs.addAll(songsList);
            }
        }
        return displayBySongs;
    }
    
    // Wasnt able to sort by the collection name in time
//    public LinkedList<Song> sortByCollection(String sortChoice, Integer listID){
//        
//    }
}
