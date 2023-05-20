package org.example.lab11.src.main.java.org.example.controllers;

//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.lab11.src.main.java.org.example.repositories.PlayerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.example.lab10.ServerApplication.src.main.java.org.example.Player;

@RestController
@RequestMapping("/players")
//@Tag(name = "Player Management")
public class PlayerController {

    private PlayerRepository playerRepository= new PlayerRepository();

    @PostMapping("/add")
    //@Operation(summary = "Add a new player")
    public ResponseEntity<String> addPlayer(@RequestBody Player player) {
        playerRepository.addPlayer(player);
        return ResponseEntity.ok("Player added successfully");
    }

    @GetMapping("/view")
    //@Operation(summary = "Get all players")
    public List<Player> getAllPlayers() {
        return playerRepository.getPlayers();
    }

    @PutMapping("changeName/{id}")
    //@Operation(summary = "Update player name")
    public ResponseEntity<String> updatePlayerName(@PathVariable int id, @RequestBody Player player) {
        if(playerRepository.updatePlayerName(id, player.getPlayerName()) == 1)
            return ResponseEntity.ok("Player found and name updated successfully");
        return ResponseEntity.ok("Player not found");
    }

    @DeleteMapping("delete/{id}")
    //@Operation(summary = "Delete player by ID")
    public ResponseEntity<String> deletePlayer(@PathVariable int id) {
        if(playerRepository.deletePlayer(id) == 1)
            return ResponseEntity.ok("Player found and deleted successfully");
        return ResponseEntity.ok("Player not found");
    }
}
