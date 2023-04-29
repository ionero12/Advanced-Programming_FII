package org.example.lab8.homework;

import org.example.lab8.compulsory.Artist;
import org.example.lab8.compulsory.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {

    private final Connection conn;

    public ArtistDAO() throws SQLException {
        conn = DatabaseManager.getConnection();
    }

    public void addArtist(Artist artist) throws SQLException {
        String sql = "INSERT INTO artists (artist_id, artist_name) VALUES (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, artist.getId());
        statement.setString(2, artist.getName());
        statement.executeUpdate();
    }

    public void deleteArtist(int artistId) throws SQLException {
        String sql = "DELETE FROM artists WHERE artist_id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, artistId);
        statement.executeUpdate();
    }

    public Integer findByName(String name) throws SQLException {
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT artist_id FROM artists WHERE artist_name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT artist_name FROM artists WHERE artist_id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public List<Artist> getAllArtists() throws SQLException {
        String sql = "SELECT * FROM artists";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Artist> artists = new ArrayList<>();
        while (rs.next()) {
            Artist artist = new Artist(rs.getInt("artist_id"), rs.getString("artist_name"));
            artists.add(artist);
        }
        return artists;
    }


}
