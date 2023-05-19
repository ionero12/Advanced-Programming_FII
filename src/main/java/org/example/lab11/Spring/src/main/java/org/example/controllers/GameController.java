package org.example.lab11.Spring.src.main.java.org.example.controllers;

import org.example.lab10.ServerApplication.src.main.java.org.example.Game;
import org.example.lab11.Spring.src.main.java.org.example.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private GameService gameRepository = new GameService();

    @PostMapping("/add")
    public ResponseEntity<String> addGame(@RequestBody Game game) {
        gameRepository.addGame(game);
        return ResponseEntity.ok("Game added successfully");
    }

    @GetMapping("/view")
    public List<Game> getAllGames() {
        return gameRepository.getGames();
    }
}
