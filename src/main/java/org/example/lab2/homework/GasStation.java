package org.example.lab2.homework;

import org.example.lab2.compulsory.Location;

/**
 * Clasa GasStation mosteneste clasa Location si mai adauga cateva atribute:pretul benzinei si numarul de pompe.
 * Am creeat getterele si setterele, constructorul necesar si am dat din nou override la metoda toString().
 */

public class GasStation extends Location {
    private double gasPrice;
    private int gasolinePumps;

    public GasStation(String name, String type, double x, double y, double gasPrice, int gasolinePumps) {
        super(name, type, x, y);
        this.gasPrice = gasPrice;
        this.gasolinePumps = gasolinePumps;
    }

    public double getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(double gasPrice) {
        this.gasPrice = gasPrice;
    }

    public int getGasolinePumps() {
        return gasolinePumps;
    }

    public void setGasolinePumps(int gasolinePumps) {
        this.gasolinePumps = gasolinePumps;
    }

    @Override
    public String toString() {
        return "Compulsory.Location{" +
                "name='" + getName() + '\'' +
                ", type=" + getType() +
                ", x=" + getX() +
                ", y=" + getY() +
                ", gasPrice=" + gasPrice +
                ", gasolinePumps=" + gasolinePumps +
                '}';
    }
}
