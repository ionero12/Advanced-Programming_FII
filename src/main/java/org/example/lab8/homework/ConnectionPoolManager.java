package org.example.lab8.homework;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionPoolManager {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/music_library";
    private static final String USER = "root";
    private static final String PASS = "ioneroot";

    private static BasicDataSource dataSource = null;

    private ConnectionPoolManager() {
    }

    public static BasicDataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/music_library");
            dataSource.setUsername("root");
            dataSource.setPassword("ioneroot");
        }
        return dataSource;
    }
}
