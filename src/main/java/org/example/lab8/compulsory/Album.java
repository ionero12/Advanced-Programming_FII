package org.example.lab8.compulsory;

public class Album {

    private final int id;
    private final int releaseYear;
    private final String title;
    private Artist artist;
    private Genre genres;

    public Album(int id, int releaseYear, String title) {
        this.id = id;
        this.releaseYear = releaseYear;
        this.title = title;
    }

    public Album(int id, int releaseYear, String title, Artist artist, Genre genres) {
        this.id = id;
        this.releaseYear = releaseYear;
        this.title = title;
        this.artist = artist;
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public Genre getGenres() {
        return genres;
    }
}
