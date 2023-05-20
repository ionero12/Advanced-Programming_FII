package org.example;

import org.example.models.Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootApplication
public class ClientApplication {

    RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);

        ClientApplication client = new ClientApplication();

        client.addPlayer(0, "Denisa");
        client.getAllPlayers();
        client.addPlayer(1, "Ionela");
        client.addPlayer(2, "Bianca");
        client.getAllPlayers();
        client.updatePlayerName(0, "Daniela");
        client.deletePlayer(2);
        client.getAllPlayers();
        client.getAllGames();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public void addPlayer(int id, String playerName) {
        String url = "http://localhost:8081/players/add";
        Player player = new Player(id, playerName);
        HttpEntity<Player> request = new HttpEntity<>(player);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        System.out.println("\u001B[32m" + "addPlayer: " + response.getBody() + "\u001B[0m");
    }

    public void getAllPlayers() {
        String url = "http://localhost:8081/players/view";
        ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
        List players = response.getBody();
        System.out.println("\u001B[35m" + "getAllPlayers: " + players + "\u001B[0m");
    }

    public void updatePlayerName(int id, String playerName) {
        String url = "http://localhost:8081/players/changeName/{id}";
        Player player = new Player();
        player.setPlayerName(playerName);
        restTemplate.put(url, player, id);
        System.out.println("\u001B[36m" + "Player name updated successfully" + "\u001B[0m");
    }

    public void deletePlayer(int id) {
        String url = "http://localhost:8081/players/delete/{id}";
        restTemplate.delete(url, id);
        System.out.println("\u001B[31m" + "Player deleted successfully" + "\u001B[0m");
    }

    public void getAllGames(){
        String url = "http://localhost:8081/games/view";
        ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
        List games = response.getBody();
        System.out.println("\u001B[33m" + "getAllGames: " + games + "\u001B[0m");
    }
}
