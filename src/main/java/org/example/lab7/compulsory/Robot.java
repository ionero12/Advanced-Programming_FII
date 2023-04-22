package org.example.lab7.compulsory;

import java.util.Random;

public class Robot implements Runnable {
    private String name;
    private boolean running;
    ExplorationMap map;
    private Random rand;

    public Robot(String name, ExplorationMap map) {
        this.map = map;
        this.name = name;
        this.rand = new Random();
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
            /*
            if (visited) {
                System.out.println(name + " a vizitat [" + row + "," + col + "]");
            }*/

            //sleep pana la noua explorare
            try {
                Thread.sleep(rand.nextInt(500) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}