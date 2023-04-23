package org.example.lab8.compulsory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO {

    private final Connection conn;

    public AlbumDAO() throws SQLException {
        conn = DatabaseManager.getConnection();
    }

    public void addAlbum(Album album) throws SQLException {
        String sql = "INSERT INTO albums (album_id, release_year, title, artist, genres) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, album.getId());
        statement.setInt(2, album.getReleaseYear());
        statement.setString(3, album.getTitle());
        statement.setString(4, album.getArtist().getName());
        statement.setString(5, album.getGenres().getName());
        statement.executeUpdate();
    }

    public void deleteAlbum(int albumId) throws SQLException {
        String sql = "DELETE FROM albums WHERE album_id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, albumId);
        statement.executeUpdate();
    }

    public Integer findByTile(String title) throws SQLException {
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT album_id FROM albums WHERE title='" + title + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT title FROM albums WHERE album_id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public List<Album> getAllAlbums() throws SQLException {
        String sql = "SELECT * FROM albums";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Album> albums = new ArrayList<>();
        while (rs.next()) {
            Album album = new Album(rs.getInt("album_id"), rs.getInt("release_year"), rs.getString("title"));
            albums.add(album);
        }
        return albums;
    }


}
