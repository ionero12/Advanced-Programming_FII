package org.example.lab2.homework;

import org.example.lab2.compulsory.Location;

/**
 * Clasa Airport mosteneste clasa Location si mai adauga cateva atribute: numarul de piste si numarul de terminale.
 * Am creeat getterele si setterele, constructorul necesar si am dat din nou override la metoda toString().
 */
public class Airport extends Location {
    private int runwayNumber;
    private int terminalsNumber;


    public Airport(String name, String type, double x, double y, int runwayNumber, int terminalsNumber) {
        super(name, type, x, y);
        this.runwayNumber = runwayNumber;
        this.terminalsNumber = terminalsNumber;
    }

    public int getRunwayNumber() {
        return runwayNumber;
    }

    public void setRunwayNumber(int runways) {
        this.runwayNumber = runways;
    }

    public int getTerminalsNumber() {
        return terminalsNumber;
    }

    public void setTerminalsNumber(int terminals) {
        this.terminalsNumber = terminals;
    }

    @Override
    public String toString() {
        return "Compulsory.Location{" +
                "name='" + getName() + '\'' +
                ", type=" + getType() +
                ", x=" + getX() +
                ", y=" + getY() +
                ", runwayNumber=" + runwayNumber +
                ", terminalsNumber=" + terminalsNumber +
                '}';
    }
}