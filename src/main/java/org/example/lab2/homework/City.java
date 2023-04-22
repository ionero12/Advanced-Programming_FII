package org.example.lab2.homework;

import org.example.lab2.compulsory.Location;

/**
 * Clasa City mosteneste clasa Location si mai adauga cateva atribute: populatia.
 * Am creeat getterele si setterele, constructorul necesar si am dat din nou override la metoda toString().
 */
public class City extends Location {
    private int population;

    public City(String name, String type, double x, double y, int population) {
        super(name, type, x, y);
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Compulsory.Location{" +
                "name='" + getName() + '\'' +
                ", type=" + getType() +
                ", x=" + getX() +
                ", y=" + getY() +
                ", population=" + population +
                '}';
    }
}
