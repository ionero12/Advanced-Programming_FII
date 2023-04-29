package org.example.lab8.compulsory;

import org.example.lab8.homework.ArtistDAO;
import org.example.lab8.homework.GenreDAO;

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

        List<Album> albums = albumDAO.getAllAlbums();
        for (Album album : albums)
            System.out.println(album.getId() + " - " + album.getReleaseYear() + " - " + album.getTitle());
        System.out.println("Number of albums: " + albums.size());

        albumDAO.deleteAlbum(2);

        System.out.println("Album with title Perfect Day: " + albumDAO.findByTile("Perfect Day"));
        System.out.println("Album with index 1: " + albumDAO.findById(1));
        System.out.println();

        ArtistDAO artistDAO = new ArtistDAO();

        Artist artist1 = new Artist(1, "Selena Gomez");
        artistDAO.addArtist(artist1);

        Artist artist2 = new Artist(2, "Taylor Swift");
        artistDAO.addArtist(artist2);

        Artist artist3 = new Artist(3, "The Who");
        artistDAO.addArtist(artist3);

        List<Artist> artists = artistDAO.getAllArtists();
        for (Artist artist : artists)
            System.out.println(artist.getId() + " - " + artist.getName());
        System.out.println("Number of artist: " + artists.size());

        artistDAO.deleteArtist(2);

        System.out.println("Artist with name Selena Gomez: " + artistDAO.findByName("Selena Gomez"));
        System.out.println("Artist with index 1: " + artistDAO.findById(1));
        System.out.println();


        GenreDAO genreDAO = new GenreDAO();

        Genre genre1 = new Genre(1, "pop");
        genreDAO.addGenre(genre1);

        Genre genre2 = new Genre(2, "rock");
        genreDAO.addGenre(genre2);

        Genre genre3 = new Genre(3, "jazz");
        genreDAO.addGenre(genre3);

        List<Genre> genres = genreDAO.getAllGenres();
        for (Genre genre : genres)
            System.out.println(genre.getId() + " - " + genre.getName());
        System.out.println("Number of genres: " + genres.size());

        genreDAO.deleteGenre(2);

        System.out.println("Genre with name jazz: " + genreDAO.findByName("jazz"));
        System.out.println("Genre with index 1: " + genreDAO.findById(1));
    }
}


