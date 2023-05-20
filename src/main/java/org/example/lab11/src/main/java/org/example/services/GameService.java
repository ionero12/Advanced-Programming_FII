package org.example.services;


import org.example.models.Game;

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