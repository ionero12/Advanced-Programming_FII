package org.example.lab7.compulsory;

import java.util.Random;

public class Robot implements Runnable {
    ExplorationMap map;
    int nrTokens;
    private final String name;
    private boolean running;
    private final Random rand;

    public Robot(String name, ExplorationMap map) {
        this.map = map;
        this.name = name;
        this.rand = new Random();
        this.nrTokens = 0;
    }

    public int getNrTokens() {
        return nrTokens;
    }

    public void addTokens(int tokens) {
        this.nrTokens+=tokens;
    }

    public String getName() {
        return name;
    }


    public void run() {
        running = true;
        while (running) {
            //se alege random o celula de pe mapa
            int row = rand.nextInt(map.getN());
            int col = rand.nextInt(map.getN());

            //viziteaza celula si extrage tokenii
            boolean visited = map.visit(row, col, this);

            //sleep pana la noua explorare
            try {
                Thread.sleep(rand.nextInt(500) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}