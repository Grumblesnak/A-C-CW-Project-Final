package b00394105_comp09044_cw2_final;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

public class MusicList {
    LinkedList<Song> songs = new LinkedList<>();
    CollectionList collectionList = CollectionListSingleton.getInstance().getCollectionList();
    Integer songCount;
    
    public MusicList(){
        
    }
    
    public void addSong(String title, String artist, String genre, Integer releaseYear, Integer songID, Integer listID){
        Song newSong = new Song(title, artist, genre, releaseYear, songID, listID);
        songs.add(newSong);
    }
    
    public boolean checkSongTitle(String title, Integer listID){
        boolean songExists = false;
        for(int i = 0; i < songs.size(); i++){
            if(songs.get(i).title.equals(title) && songs.get(i).listID.equals(listID)){
                songExists = true;
            }
        }
        return songExists;
    }
    
    public boolean checkArtist(String artist, Integer listID){
        boolean correctArtist = false;
        for(int i = 0; i < songs.size(); i++){
            if(songs.get(i).artist.equals(artist) && songs.get(i).listID.equals(listID)){
                correctArtist = true;
            }
        }
        return correctArtist;
    }
    
    public void deleteSong(String title, String artist, Integer listID){
        for(int i = 0; i< songs.size(); i++){
            if(songs.get(i).title.equals(title) && songs.get(i).artist.equals(artist) && songs.get(i).listID.equals(listID)){
                songs.remove(i);
            }
        }
    }
    
    public void updateSong(String title, String artist, String genre, Integer releaseYear, Integer listID, Integer songID){
        for(int i = 0; i< songs.size(); i++){
            if(songs.get(i).listID.equals(listID) && songs.get(i).songID.equals(songID)){
                songs.get(i).title = title;
                songs.get(i).artist = artist;
                songs.get(i).genre = genre;
                songs.get(i).releaseYear = releaseYear;
            }
        }
    }
    
    public Integer getCount(){
        songCount = songs.size();
        return songCount;
    }
    
    public Integer getSongID(String title, String artist, Integer listID){
        Integer retrieveSongID = null;
        for(int i = 0; i < songs.size(); i++){
            if(songs.get(i).title.equals(title) && songs.get(i).artist.equals(artist) && songs.get(i).listID.equals(listID)){
                retrieveSongID = songs.get(i).songID;
            }
        }
        return retrieveSongID;
    }
    
    public LinkedList<Song> displaySongs(Integer listID){
        LinkedList<Song> songsList = new LinkedList<>();
        if(songs != null && songs.size() > 0){
            for (int i = 0; i < songs.size(); i++){
                if(songs.get(i).listID.equals(listID)){
                    songsList.add(songs.get(i));
                }
            }
        }
        return songsList;
    }
    
    public LinkedList<Song> displayByTitle(String specification, Integer listID){
        LinkedList<Song> displayBySongs = new LinkedList<>();
        if(songs != null && songs.size() > 0){
            for (int i = 0; i < songs.size(); i++){
                if(songs.get(i).title.contains(specification) && songs.get(i).listID.equals(listID)){
                    displayBySongs.add(songs.get(i));
                }
            }
        }
        return displayBySongs;
    }
    
    public LinkedList<Song> displayByArtist(String specification, Integer listID){
        LinkedList<Song> displayBySongs = new LinkedList<>();
        if(songs != null && songs.size() > 0){
            for (int i = 0; i < songs.size(); i++){
                if(songs.get(i).artist.contains(specification) && songs.get(i).listID.equals(listID)){
                    displayBySongs.add(songs.get(i));
                }
            }
        }
        return displayBySongs;
    }
    
    public LinkedList<Song> displayByGenre(String specification, Integer listID){
        LinkedList<Song> displayBySongs = new LinkedList<>();
        if(songs != null && songs.size() > 0){
            for (int i = 0; i < songs.size(); i++){
                if(songs.get(i).genre.contains(specification) && songs.get(i).listID.equals(listID)){
                    displayBySongs.add(songs.get(i));
                }
            }
        }
        return displayBySongs;
    }
    
    public LinkedList<Song> displayByYear(Integer specification, Integer listID){
        LinkedList<Song> displayBySongs = new LinkedList<>();
        if(songs != null && songs.size() > 0){
            for (int i = 0; i < songs.size(); i++){
                if(songs.get(i).releaseYear.equals(specification) && songs.get(i).listID.equals(listID)){
                    displayBySongs.add(songs.get(i));
                }
            }
        }
        return displayBySongs;
    }
    
    public LinkedList<Song> displayByCollection(String specification, Integer listID, Integer collectionID){
        LinkedList<Song> displayBySongs = new LinkedList<>();
        Set<Song> addedSongs = new HashSet<>();
        if(songs != null && songs.size() > 0){
            for (int i = 0; i < songs.size(); i++){
                if(songs.get(i).listID.equals(listID)){
                    Collection collection = collectionList.getCollectionByID(specification, listID);
                    if(collection != null){
                        for (int j = 0; j < collection.collectionSongs.size(); j++){
                            var song = collection.collectionSongs.get(j);
                            if(!addedSongs.contains(song)){
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
    
    public Song getSongByID(String title, String artist, Integer listID){
        for(int i = 0; i < songs.size(); i++){
            if(songs.get(i).title.equals(title) && songs.get(i).artist.equals(artist) && songs.get(i).listID.equals(listID)){
                return songs.get(i);
            }
        }
        return null;
    }
    
    public LinkedList<Song> sortByTitle(String sortChoice, Integer listID){
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
                        int compareResult = song1.title.compareTo(song2.title);

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
    
//    public LinkedList<Song> sortByCollection(String sortChoice, Integer listID){
//        
//    }
}
