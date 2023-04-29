package org.example.lab8.homework;

import org.example.lab8.compulsory.Genre;
import org.example.lab8.compulsory.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {

    private final Connection conn;

    public GenreDAO() throws SQLException {
        conn = DatabaseManager.getConnection();
    }

    public void addGenre(Genre genre) throws SQLException {
        String sql = "INSERT INTO genres (genre_id, genre_name) VALUES (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, genre.getId());
        statement.setString(2, genre.getName());
        statement.executeUpdate();
    }

    public void deleteGenre(int genreId) throws SQLException {
        String sql = "DELETE FROM genres WHERE genre_id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, genreId);
        statement.executeUpdate();
    }

    public Integer findByName(String name) throws SQLException {
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT genre_id FROM genres WHERE genre_name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT genre_name FROM genres WHERE genre_id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public List<Genre> getAllGenres() throws SQLException {
        String sql = "SELECT * FROM genres";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Genre> genres = new ArrayList<>();
        while (rs.next()) {
            Genre genre = new Genre(rs.getInt("genre_id"), rs.getString("genre_name"));
            genres.add(genre);
        }
        return genres;
    }


}


