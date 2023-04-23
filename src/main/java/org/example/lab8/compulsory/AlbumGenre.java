package org.example.lab8.compulsory;

public class AlbumGenre {
    private int albumId;
    private int genreId;


    public AlbumGenre(int albumId, int genreId) {
        this.albumId = albumId;
        this.genreId = genreId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }
}