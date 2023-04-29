package org.example.lab8.compulsory;

import java.sql.Connection;

import org.example.lab8.homework.ConnectionPoolManager;

import java.sql.SQLException;

public class DatabaseManager {

    public static Connection getConnection() throws SQLException {
        return ConnectionPoolManager.getDataSource().getConnection();
    }

    public static void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
