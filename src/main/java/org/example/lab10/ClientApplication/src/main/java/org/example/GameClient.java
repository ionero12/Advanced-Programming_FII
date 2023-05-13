package org.example.lab10.ClientApplication.src.main.java.org.example;
//package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private String playerName;

    public GameClient(String serverAddress, int port) {
        try {
            socket = new Socket(serverAddress, port);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Connected to server: " + serverAddress + ":" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost";
        int port = 8888;

        int numClients = 2; // Number of clients to run

        for (int i = 0; i < numClients; i++) {
            GameClient client = new GameClient(serverAddress, port);
            client.start();
        }
    }

    public void getPlayerName() throws IOException {
        System.out.println("Add name: ");
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        playerName = consoleReader.readLine();
        System.out.println();
    }

    public void start() throws IOException {
        getPlayerName();
        try {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String command;
            while ((command = consoleReader.readLine()) != null) {
                writer.println(command + " " + playerName);
                String response = reader.readLine();
                System.out.println("Server response: " + response);
                if (command.equals("exit")) {
                    break;
                } else if (response.equals("Server stopped")) {
                    break;
                }
            }
            socket.close();
            System.out.println("Disconnected from server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
