package org.example.lab7.compulsory;

import org.example.lab7.homework.DaemonThread;

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

    public void start() throws InterruptedException {
        for (Robot robot : robots) {
            new Thread(robot).start();
        }
    }

    public  void showStatistics(){
        for(Robot robot:robots){
            System.out.println(robot.getName() + " a adunat "+ robot.getNrTokens() + " tokeni");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        var explore = new Exploration();
        DaemonThread timekeeper=new DaemonThread(10, explore);
        new Thread(timekeeper).start();
        explore.addRobot(new Robot("Robo 1", explore.getMap()));
        explore.addRobot(new Robot("Robo 2", explore.getMap()));
        explore.addRobot(new Robot("Robo 3", explore.getMap()));
        explore.addRobot(new Robot("Robo 4", explore.getMap()));
        explore.addRobot(new Robot("Robo 5", explore.getMap()));
        explore.start();
    }
}