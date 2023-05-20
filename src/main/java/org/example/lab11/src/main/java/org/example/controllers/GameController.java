package org.example.controllers;

import org.example.models.Game;
import org.example.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private GameService gameService = new GameService();

    @PostMapping("/add")
    public ResponseEntity<String> addGame(@RequestBody Game game) {
        gameService.addGame(game);
        return ResponseEntity.ok("Game added successfully");
    }

    @GetMapping("/view")
    public List<Game> getAllGames() {
        return gameService.getGames();
    }
}
