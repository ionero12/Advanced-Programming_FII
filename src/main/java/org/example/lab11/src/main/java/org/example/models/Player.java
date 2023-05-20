package org.example.models;

public class Player {
    private int id;
    String playerName;

    public Player() {
    }

    public Player(int id, String playerName) {
        this.id = id;
        this.playerName = playerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
