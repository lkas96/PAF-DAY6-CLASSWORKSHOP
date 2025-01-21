package vttp.b5.paf.day6.classworkshop.Day6.Class.Workshop.Spotify.Songs.models;

public class Song {
    
    private int year;
    private String artiste;
    private String songName;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Song(int year, String artiste, String songName) {
        this.year = year;
        this.artiste = artiste;
        this.songName = songName;
    }

    public Song() {

    }

    @Override
    public String toString() {
        return "Song [year=" + year + ", artiste=" + artiste + ", songName=" + songName + "]";
    }

}
