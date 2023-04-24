package b00394105_comp09044_cw2_final;

// Class Song is used for the structure of each node in MusicList
// Strings title, artist, and genre are all set when adding new songs
// Integers releaseYear is also set when adding new songs but has checks to ensure input remain integers
// songID and listID are used to help identify a song and which user it belongs to (userID and listID for users function the same at this point)
public class Song {
    public String title, artist, genre;
    public Integer releaseYear, songID, listID;
    
    // The structure of a song when created/called in MusicList for adding new songs
    public Song(String title, String artist, String genre, Integer releaseYear, Integer songID, Integer listID){
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.songID = songID;
        this.listID = listID;
    }
    
    // Override will ensure that when displaying individual songs (in a text area) that this structure is taken
    // Rather than a default unintelligble message
    @Override
    public String toString(){
        return this.title + " --- " + this.artist + " --- " + this.genre + " --- " + this.releaseYear;
    }
}
