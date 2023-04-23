package org.example.lab7.homework;

import org.example.lab7.compulsory.Exploration;

public class DaemonThread extends Thread {
    private final int timeLimitInSeconds;
    private boolean stopExploration = false;
    Exploration exp;

    public DaemonThread(int timeLimitInSeconds, Exploration exp) {
        this.timeLimitInSeconds = timeLimitInSeconds;
        this.exp=exp;
        setDaemon(true);
    }

    @Override
    public void run() {
        int elapsedSeconds = 0;
        while (!stopExploration) {
            System.out.println("Exploration has been running for " + elapsedSeconds + " seconds");
            if (elapsedSeconds >= timeLimitInSeconds) {
                System.out.println("Time limit of " + timeLimitInSeconds + " seconds has been reached. Stopping exploration.");
                stopExploration = true;
                exp.showStatistics();
                System.exit(0);
            }
            elapsedSeconds++;
            try {
                Thread.sleep(1000); // wait for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
