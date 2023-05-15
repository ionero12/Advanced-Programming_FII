package org.example.lab2;

import org.example.lab2.bonus.Solution;
import org.example.lab2.compulsory.Location;
import org.example.lab2.compulsory.Road;
import org.example.lab2.compulsory.RoadType;
import org.example.lab2.homework.Airport;
import org.example.lab2.homework.City;
import org.example.lab2.homework.GasStation;
import org.example.lab2.homework.Instance;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Location city1 = new City("Iasi", "city", 47.1622, 27.5889, 500000);
        Location city2 = new City("Roman", "city", 46.93, 26.93, 20000);
        Location city3 = new City("Cluj", "city", 146.93, 126.93, 120000);
        Location gasStation1 = new GasStation("OMV Bucuresti", "gas station", 44.4353, 26.1028, 6.99, 10);
        Location airport1 = new Airport("New York Homework.Airport", "airport", 40.7306, -73.935, 20, 10);
        Road road1 = new Road(RoadType.EXPRESS, 85.6, 100, city1, city2);
        Road road2 = new Road(RoadType.COUNTRY, 337, 120, city2, gasStation1);
        Road road3 = new Road(RoadType.HIGHWAYS, 7646, 150, gasStation1, airport1);

        Instance instance1 = new Instance();
        instance1.addLocations(city1);
        instance1.addLocations(city2);
        instance1.addLocations(city3);
        instance1.addLocations(gasStation1);
        instance1.addLocations(airport1);
        instance1.addLocations(gasStation1); // nu o sa mearga pt ca am adaugat deja locatia
        instance1.addRoads(road1);
        instance1.addRoads(road2);
        instance1.addRoads(road3);
        System.out.println("Este instanta problemei valida?");
        System.out.println(instance1.isValid());
        System.out.println();
        System.out.println("Exista drum de la city1 la city2?");
        System.out.println(instance1.isRoad(city1, city2));
        System.out.println();
        System.out.println("Exista drum de la city1 la gasStation1?");
        System.out.println(instance1.isRoad(city1, gasStation1));
        System.out.println();
        System.out.println("Exista drum de la airport1 la city3?");
        System.out.println(instance1.isRoad(airport1, city3)); // false (nu exista niciun fel de drum)
        System.out.println();


        Solution sol = new Solution();
        sol.addLocations(city1);
        sol.addLocations(city2);
        sol.addLocations(city3);
        sol.addLocations(gasStation1);
        sol.addLocations(airport1);
        sol.addLocations(gasStation1); // nu o sa mearga pt ca am adaugat deja locatia
        sol.addRoads(road1);
        sol.addRoads(road2);
        sol.addRoads(road3);

        Location startLocation = city1; // Specify the start location
        Location finishLocation = airport1; // Specify the finish location

        List<Road> shortestPath = sol.shortestPath(startLocation, finishLocation);
        if (shortestPath.isEmpty()) {
            System.out.println("No path found.");
        } else {
            System.out.println("Shortest path:");
            for (Road road : shortestPath) {
                System.out.println(road);
            }
        }
    }
}