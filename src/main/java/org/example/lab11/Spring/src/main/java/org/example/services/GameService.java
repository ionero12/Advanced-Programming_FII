package org.example.lab11.Spring.src.main.java.org.example.services;

import org.example.lab10.ServerApplication.src.main.java.org.example.Game;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private List<Game> games = new ArrayList<>();

    public List<Game> getGames() {
        return games;
    }

    public void addGame(Game game) {
        games.add(game);
    }
}