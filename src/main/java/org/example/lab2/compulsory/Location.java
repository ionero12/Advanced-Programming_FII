package org.example.lab2.compulsory;

import java.util.Objects;

/**
 * Clasa Location are 4 atribute pentru: nume, tip si coordonatele spatiale ale locatiilor. Am implementat
 * constructorul si getterele si setterele necesare. Apoi am dat override la metodele toString() si equals().
 * Clasa descrie locatii care pot fi: orase, aeropoarte, benzinarii etc.
 */

public class Location {
    private String name;
    private String type;
    private double x;
    private double y;

    public Location(String name, String type, double x, double y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public Location(double x, double y){
        this.x=x;
        this.y=y;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setName(String name1) {
        name = name1;
    }

    public void setType(String type1) {
        type = type1;
    }

    public void setX(double x1) {
        x = x1;
    }

    public void setY(double y1) {
        y = y1;
    }

    @Override
    public String toString() {
        return "Compulsory.Location{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(location.x, x) == 0 && Double.compare(location.y, y) == 0 && Objects.equals(name, location.name) && Objects.equals(type, location.type);
    }

}