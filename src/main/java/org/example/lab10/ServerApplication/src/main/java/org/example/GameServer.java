package org.example.lab10.ServerApplication.src.main.java.org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.lab10.ServerApplication.src.main.java.org.example.ConsoleColor.*;


public class GameServer {
    private ServerSocket serverSocket;
    private List<ClientThread> clients;
    private Map<String, Game> games;

    public GameServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.clients = new ArrayList<>();
        this.games = new HashMap<>();
    }

    public static void main(String[] args) {
        GameServer gameServer = new GameServer(8888);
        gameServer.start();
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public List<ClientThread> getClients() {
        return clients;
    }

    public void setClients(List<ClientThread> clients) {
        this.clients = clients;
    }

    public Map<String, Game> getGames() {
        return games;
    }

    public void setGames(Map<String, Game> games) {
        this.games = games;
    }

    public void start() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println(BLUE + "New client connected: " + clientSocket.getInetAddress());
                ClientThread clientThread = new ClientThread(clientSocket, this);
                clients.add(clientThread);
                clientThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void createGame(String gameName, String playerName) {
        Game game = new Game(gameName);
        games.put(gameName, game);
        System.out.println(GREEN + "Game: " + gameName + " created by player: " + playerName);
    }

    public int joinGame(String gameName, String playerName) {
        Game game = games.get(gameName);
        if (game != null) {
            int ok = game.addPlayer();
            if (ok == 1) {
                System.out.println(YELLOW + "Player " + playerName + " joined the game: " + gameName);
                return 1;
            } else if (ok == 0) {
                System.out.println(RED + "Max number of players");
                return 0;
            }
        } else {
            System.out.println(RED + "Game not found: " + gameName);
            return -1;
        }
        return -2;
    }
}

