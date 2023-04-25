JDBC
Write an application that allows to connect to a relational database by using JDBC, submit SQL statements and display the results.
The main specifications of the application are:

## Compulsory (1p)

Create a relational database using any RDBMS (Oracle, Postgres, MySql, Java DB, etc.).
Write an SQL script that will create the following tables:
albums: id, release year, title, artist, genre(s)
artists: id, name (for example: Beatles)
genres: id, name (for example: Rock)
an associative (junction) table in order to store each album genres
Update pom.xml, in order to add the database driver to the project libraries.
Create a singleton class in order to manage a connection to the database.
Create DAO classes that offer methods for managing artists, genres and albums (at least one).
Implement a simple test using your classes.

## Optional (2p)
Create an object-oriented model of the data managed by the Java application.
Implement all the DAO classes.
Use a connection pool in order to manage database connections, such as C3PO, HikariCP or Apache Commons DBCP.
Create a tool to import data from a real dataset, such as Rolling Stone's 500 Greatest Albums of All Time (or other)

## Implementare
Primul pas a fost identificarea claselor de care avem nevoie. In functie de cerinta, am scris script-ul SQL pe care l-am rulat in MySql Workbench si s-au creat tabelele cerute. Am adaugat dependintele in fisierul pom apoi am implementat clasa DatabaseManager care face legatura cu baza de date. Ulterior, am creat clasa AlbumDAO care are cateva caracteristici: insereaza in tabel valori, sterge din tabel valori, afiseaza toate liniile din tabel, cauta in tabel in functie de anumite cerinte (id, titlu).