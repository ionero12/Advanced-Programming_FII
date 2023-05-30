package org.example.controllers;

//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import org.example.models.Game;
import org.example.models.Player;
import org.example.repositories.PlayerRepository;
import org.example.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
//@Api(tags = "Player Management")
public class PlayerController {

    private PlayerRepository playerRepository= new PlayerRepository();
    private GameService gameService = new GameService();

    @PostMapping("/add")
    //@ApiOperation("Add a new player")
    public ResponseEntity<String> addPlayer(@RequestBody Player player) {
        playerRepository.addPlayer(player);
        return ResponseEntity.ok("Player added successfully");
    }

    @GetMapping("/view")
    //@ApiOperation("Get all players")
    public List<Player> getAllPlayers() {
        return playerRepository.getPlayers();
    }

    @GetMapping("/view/games")
    //@ApiOperation("Get all games")
    public List<Game> getAllGames() {
        return gameService.getGames();
    }

    @PutMapping("changeName/{id}")
    //@ApiOperation("Update player name")
    public ResponseEntity<String> updatePlayerName(@PathVariable int id, @RequestBody Player player) {
        if(playerRepository.updatePlayerName(id, player.getPlayerName()) == 1)
            return ResponseEntity.ok("Player found and name updated successfully");
        return ResponseEntity.ok("Player not found");
    }

    @DeleteMapping("delete/{id}")
    //@ApiOperation("Delete player by ID")
    public ResponseEntity<String> deletePlayer(@PathVariable int id) {
        if(playerRepository.deletePlayer(id) == 1)
            return ResponseEntity.ok("Player found and deleted successfully");
        return ResponseEntity.ok("Player not found");
    }


}

