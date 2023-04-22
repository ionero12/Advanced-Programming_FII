package org.example.lab7.compulsory;

import java.util.ArrayList;
import java.util.List;


public class Exploration {
    private final SharedMemory memory = new SharedMemory(5);
    private final ExplorationMap map = new ExplorationMap(5, memory);
    private final List<Robot> robots = new ArrayList<>();


    public ExplorationMap getMap() {
        return map;
    }


    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    public void start() {
        //creeaza un nou thread pt fiecare robot
        for (Robot robot : robots) {
            new Thread(robot).start();
        }
    }

    public static void main(String[] args) {
        var explore = new Exploration();
        explore.addRobot(new Robot("Robo 1", explore.getMap()));
        explore.addRobot(new Robot("Robo 2", explore.getMap()));
        explore.addRobot(new Robot("Robo 3", explore.getMap()));
        explore.addRobot(new Robot("Robo 4", explore.getMap()));
        explore.addRobot(new Robot("Robo 5", explore.getMap()));
        explore.start();
    }
}
