package b00394105_comp09044_cw2_final;

public class Song {
    public String title, artist, genre;
    public Integer releaseYear, songID, listID;
    
    public Song(String title, String artist, String genre, Integer releaseYear, Integer songID, Integer listID){
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.songID = songID;
        this.listID = listID;
    }
    
    @Override
    public String toString(){
        return this.title + " --- " + this.artist + " --- " + this.genre + " --- " + this.releaseYear;
    }
}
