package org.example.lab11.Spring.src.main.java.org.example.controllers;

import org.example.lab10.ServerApplication.src.main.java.org.example.Player;
import org.example.lab11.Spring.src.main.java.org.example.repositories.PlayerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

@RestController
@RequestMapping("/players")
@Api(tags = "Player API")
public class PlayerController {

    private PlayerRepository playerRepository = new PlayerRepository();

    @PostMapping("/add")
    @ApiOperation("Add a player")
    public ResponseEntity<String> addPlayer(@RequestBody Player player) {
        playerRepository.addPlayer(player);
        return ResponseEntity.ok("Player added successfully");
    }

    @GetMapping("/view")
    @ApiOperation("Get all players")
    public List<Player> getAllPlayers() {
        return playerRepository.getPlayers();
    }

    @PutMapping("changeName/{id}")
    @ApiOperation("Update a player's name")
    public ResponseEntity<String> updatePlayerName(
            @ApiParam(value = "Player ID", required = true) @PathVariable int id,
            @RequestBody Player player) {
        if (playerRepository.updatePlayerName(id, player.getPlayerName()) == 1)
            return ResponseEntity.ok("Player found and name updated successfully");
        return ResponseEntity.ok("Player not found");
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation("Delete a player")
    public ResponseEntity<String> deletePlayer(
            @ApiParam(value = "Player ID", required = true) @PathVariable int id) {
        if (playerRepository.deletePlayer(id) == 1)
            return ResponseEntity.ok("Player found and deleted successfully");
        return ResponseEntity.ok("Player not found");
    }
}
