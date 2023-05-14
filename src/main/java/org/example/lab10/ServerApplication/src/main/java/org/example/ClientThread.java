package org.example.lab10.ServerApplication.src.main.java.org.example;

import org.example.lab11.Spring.src.main.java.org.example.compulsory.PlayerController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashSet;

class ClientThread extends Thread {
    private final Socket clientSocket;
    private GameServer gameServer;
    private BufferedReader reader;
    private PrintWriter writer;
    PlayerController players;

    public ClientThread(Socket socket, GameServer gameServer) {
        clientSocket = socket;
        this.gameServer = gameServer;
        this.players= new PlayerController();
        try {
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            writer = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public GameServer getGameServer() {
        return gameServer;
    }

    public void setGameServer(GameServer serverSocket) {
        this.gameServer = serverSocket;
    }

    public BufferedReader getReader() {
        return reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public PrintWriter getWriter() {
        return writer;
    }

    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }

    public void run() {
        try {
            String request;
            while ((request = reader.readLine()) != null) {
                if (request.startsWith("stop")) {
                    writer.println("Server stopped");
                    System.exit(0);
                    break;
                } else if (request.startsWith("create game")) {
                    //creeaza joc
                    //System.out.println(request);
                    String[] command = request.split(" ");
                    String gameName = command[2];
                    String playerName = command[3];
                    players.addPlayer(new Player(playerName));
                    gameServer.createGame(gameName, playerName);
                    writer.println("Game created: " + gameName);
                } else if (request.startsWith("join game")) {
                    //join la un joc
                    String[] command = request.split(" ");
                    String gameName = command[2];
                    String playerName = command[3];
                    players.addPlayer(new Player(playerName));
                    int value = gameServer.joinGame(gameName, playerName);
                    if (value == 1) writer.println("You joined the game: " + gameName);
                    else if (value == 0) writer.println("Sorry, maximum number of players reached");
                    else writer.println("Sorry, game not found");
                } else if (request.startsWith("submit move")) {
                    //habar n am
                    String[] command = request.split(" ");
                    int row = Integer.parseInt(command[2]);
                    int col = Integer.parseInt(command[3]);
                    String playerName = command[4];
                    // Submit move logic here
                    writer.println("Submitted move: row " + row + ", column " + col);
                } else {
                    writer.println("Server received the request: " + request);
                }
            }
            clientSocket.close();
            System.out.println("Client disconnected: " + clientSocket.getInetAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
