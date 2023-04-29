package org.example.lab8.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RollingStoneAlbumImporter {

    private static final String CSV_FILE_PATH = "D:\\Facultate\\An 2 Semestru 2\\PA - Programare avansata\\Programare_Avansata\\src\\main\\java\\org\\example\\lab8\\homework\\albumlist.csv";
    private static final String INSERT_ALBUM_SQL = "INSERT IGNORE INTO albums (album_id, release_year, title, artist) VALUES (?, ?, ?, ?)";


    public static void importAlbums() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH)); Connection conn = ConnectionPoolManager.getDataSource().getConnection(); PreparedStatement stmt = conn.prepareStatement(INSERT_ALBUM_SQL)) {

            String line = null;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int id = 0;
                int releaseYear = 0;
                String title = "";
                String artist = "";

                if (isInteger(fields[0])) {
                    id = Integer.parseInt(fields[0]);
                }
                if (isInteger(fields[1])) {
                    releaseYear = Integer.parseInt(fields[1]);
                }
                if (fields.length > 2) {
                    title = fields[2];
                }

                if (fields.length > 2) {
                    artist = fields[3];
                }

                stmt.setInt(1, id);
                stmt.setInt(2, releaseYear);
                stmt.setString(3, title);
                stmt.setString(4, artist);
                stmt.executeUpdate();

                count++;
                System.out.println("Inserted album #" + id + ": " + title + " by " + artist + " (" + releaseYear + ")");
            }

            System.out.println("Imported " + count + " albums");

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static void main(String[] args) {
        importAlbums();
    }
}

