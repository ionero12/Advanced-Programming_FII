package org.example.lab8.compulsory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/music_library";
    private static final String USER = "root";
    private static final String PASS = "ioneroot";
    private static Connection conn = null;

    private DatabaseManager() {
    }

    public static Connection getConnection() throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }
        return conn;
    }

    public static void deleteTable(String tableName) throws SQLException {
        Connection con = DatabaseManager.getConnection();
        try (Statement stmt = con.createStatement()) {
            String query = "DELETE FROM " + tableName;
            stmt.executeUpdate(query);
            con.commit();
        }
    }

    public static void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn = null;
    }
}
