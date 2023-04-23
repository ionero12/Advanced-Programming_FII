package org.example.lab8.compulsory;

import java.sql.SQLException;
import java.util.List;

public class Test {

    public static void main(String[] args) throws SQLException {
        AlbumDAO albumDAO = new AlbumDAO();

        Album album1 = new Album(1, 1967, "Sgt. Pepper's Lonely Hearts Club Band", new Artist(12, "The Beatles"), new Genre(31, "Rock"));
        albumDAO.addAlbum(album1);

        Album album2 = new Album(2, 1971, "Who's Next", new Artist(51, "The Who"), new Genre(31, "Rock"));
        albumDAO.addAlbum(album2);

        Album album3 = new Album(3, 2003, "Perfect Day", new Artist(124, "Selena Gomez"), new Genre(22, "Pop"));
        albumDAO.addAlbum(album3);

        Album album4 = new Album(4, 2010, "Forever", new Artist(463, "Taylor Swift"), new Genre(12, "Casual"));
        albumDAO.addAlbum(album4);

        List<Album> albums = albumDAO.getAllAlbums();
        for (Album album : albums)
            System.out.println(album.getId() + " - " + album.getReleaseYear() + " - " + album.getTitle());
        System.out.println("Number of albums: " + albums.size());

        albumDAO.deleteAlbum(2);

        System.out.println("Album with title Forever: " + albumDAO.findByTile("Forever"));
        System.out.println("Album with index 1: " + albumDAO.findById(1));
    }
}


