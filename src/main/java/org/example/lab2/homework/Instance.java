package org.example.lab2.homework;

import org.example.lab2.compulsory.Location;
import org.example.lab2.compulsory.Road;

import java.util.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Clasa Instance are 2 atribute: o lista pentru locatii si o lista pentru drumuri. Am implementat constructorii
 * si getterele/setterele necesare. Am creeat metodele: addLocation() si addRoad() care adauga o locatie/drum la
 * lista doar daca nu exista deja. Apoi metoda isValid() care verifca daca toate drumurile sunt valide (folosind
 * distanta euclidiana) si metoda isRoad() care verifica daca exista vreun drum intre doua locatii.
 */

public class Instance {
    private List<Location> locations;
    private List<Road> roads;

    public Instance() {
        locations = new ArrayList<>();
        roads = new ArrayList<>();
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Road> getRoads() {
        return roads;
    }

    public void setRoads(List<Road> roads) {
        this.roads = roads;
    }

    //adaugarea unei locatii sau a unui drum nou, doar daca nu exista deja
    public void addLocations(Location location) {
        int condition = 1;
        for (Location value : locations) {
            if (value.equals(location)) {
                condition = 0;
                break;
            }
        }
        if (condition == 1) locations.add(location);
    }

    public void addRoads(Road road) {
        int condition = 1;
        for (Road value : roads) {
            if (value.equals(road)) {
                condition = 0;
                break;
            }
        }
        if (condition == 1) roads.add(road);
    }

    // verifica daca drumul poate exista
    public boolean isValid() {
        for (Road road : roads)
            if (road.getLength() <= sqrt(pow((road.getFinish().getX() - road.getStart().getX()), 2) + pow((road.getFinish().getY() - road.getStart().getY()), 2)))
                return false;
        return true;
    }

    //verifica daca exista drum intre 2 locatii
    public boolean isRoad(Location locationStart, Location locationFinish) {
        Set<Location> visited = new HashSet<>();
        if (locationStart == locationFinish) return true;
        visited.add(locationStart);
        for (Road road : roads) {
            if (road.getStart() == locationStart && !visited.contains(road.getFinish()) && (isRoad(road.getFinish(), locationFinish))) {
                return true;
            }
        }
        visited.remove(locationStart);
        return false;
    }
}

