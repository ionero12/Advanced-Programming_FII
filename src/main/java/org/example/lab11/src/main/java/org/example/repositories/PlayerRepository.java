package org.example.lab11.src.main.java.org.example.repositories;

import org.example.lab10.ServerApplication.src.main.java.org.example.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {
    private List<Player> players= new ArrayList<>();

    public List<Player> getPlayers(){
        return players;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public int updatePlayerName(int id, String name){
        for(Player p: players){
            if(p.getId() == id){
                p.setPlayerName(name);
                return 1;
            }
        }
        return 0;
    }

    public int deletePlayer(int id){
        for(Player p: players){
            if(p.getId() == id){
                players.remove(p);
                return 1;
            }
        }
        return 0;
    }


}
