package org.example.lab11.Spring.src.main.java.org.example.compulsory;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.example.lab10.ServerApplication.src.main.java.org.example.Player;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private List<Player> players = new ArrayList<>();
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public PlayerController() {
        this.players=new ArrayList<>();
    }

    @PostMapping
    public void addPlayer(@RequestBody Player player) {
        players.add(player);
        //System.out.println(player.getPlayerName());
    }

    // GET /players
    @GetMapping
    public List<Player> getAllPlayers() {
        return players;
    }

}