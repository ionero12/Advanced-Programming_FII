package org.example.lab2.compulsory;

import java.util.Objects;

/**
 * Clasa Road are 5 atribute pentru: tip, lungime, limita de viteza si locatia de start si finish. Am implementat
 * constructorul si getterele si setterele necesare. Apoi am dat override la metodele toString() si equals().
 * Clasa descrie drumuri care pot fi: highway, express, country-road etc.
 */

public class Road {
    private RoadType type;
    private double length;
    private int speedLimit;
    private Location start;
    private Location finish;

    public Road(RoadType type, double length, int speedLimit, Location start, Location finish) {
        this.type = type;
        this.length = length;
        this.speedLimit = speedLimit;
        this.start = start;
        this.finish = finish;
    }

    public Road(Location start, Location finish, double length){
        this.start=start;
        this.finish=finish;
        this.length=length;
    }

    public RoadType getType() {
        return type;
    }

    public double getLength() {
        return length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public Location getStart() {
        return start;
    }

    public Location getFinish() {
        return finish;
    }

    public void setType(RoadType type1) {
        type = type1;
    }

    public void setLength(double length1) {
        length = length1;
    }

    public void setSpeedLimit(int speedLimit1) {
        speedLimit = speedLimit1;
    }

    public void setStart(Location start1) {
        start = start1;
    }

    public void setFinish(Location finish1) {
        finish = finish1;
    }

    @Override
    public String toString() {
        return "Compulsory.Road{" +
                "type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                ", start=" + start +
                ", finish=" + finish +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return Double.compare(road.length, length) == 0 && speedLimit == road.speedLimit && Objects.equals(type, road.type) && Objects.equals(start, road.start) && Objects.equals(finish, road.finish);
    }

}