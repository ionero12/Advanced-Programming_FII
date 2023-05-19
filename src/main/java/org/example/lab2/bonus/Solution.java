package org.example.lab2.bonus;

import org.example.lab2.compulsory.Location;
import org.example.lab2.compulsory.Road;

import java.util.*;

public class Solution {

    private List<Location> locations;
    private List<Road> roads;

    public Solution() {
        locations = new ArrayList<>();
        roads = new ArrayList<>();
    }

    public static void main(String[] args) {
        int numLocations = 500; // Number of locations in the instance
        int numRoads = 1000; // Number of roads in the instance

        Solution sol = generateRandomInstance(numLocations, numRoads);

        Location startLocation = getRandomLocation(sol.getLocations());
        Location finishLocation = getRandomLocation(sol.getLocations());

        System.out.println("Start Location: " + startLocation);
        System.out.println("Finish Location: " + finishLocation);

        long startTime = System.currentTimeMillis();

        List<Road> shortestPath = sol.shortestPath(startLocation, finishLocation);

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        if (shortestPath.isEmpty()) {
            System.out.println("No path found.");
        } else {
            System.out.println("Shortest path:");
            for (Road road : shortestPath) {
                System.out.println(road);
            }
        }

        System.out.println("Execution Time: " + executionTime + " milliseconds");
    }

    private static Solution generateRandomInstance(int numLocations, int numRoads) {
        Solution sol = new Solution();
        Random random = new Random();

        // Generate random locations
        for (int i = 0; i < numLocations; i++) {
            int x = random.nextInt(1000);
            int y = random.nextInt(1000);
            Location location = new Location(x, y);
            sol.addLocations(location);
        }

        // Generate random roads
        List<Location> locations = sol.getLocations();
        for (int i = 0; i < numRoads; i++) {
            Location start = getRandomLocation(locations);
            Location finish = getRandomLocation(locations);
            double length = calculateDistance(start, finish);
            Road road = new Road(start, finish, length);
            sol.addRoads(road);
        }

        return sol;
    }

    private static Location getRandomLocation(List<Location> locations) {
        Random random = new Random();
        int index = random.nextInt(locations.size());
        return locations.get(index);
    }

    private static double calculateDistance(Location start, Location finish) {
        double deltaX = finish.getX() - start.getX();
        double deltaY = finish.getY() - start.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
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

    // Find the shortest road using Dijkstra's algorithm
    public List<Road> shortestPath(Location start, Location finish) {
        Map<Location, Double> distance = new HashMap<>();
        Map<Location, Road> previousRoad = new HashMap<>();
        Set<Location> unvisited = new HashSet<>(locations);

        // Initialize distances to infinity except for the start location
        for (Location location : locations) {
            distance.put(location, Double.POSITIVE_INFINITY);
        }
        distance.put(start, 0.0);

        while (!unvisited.isEmpty()) {
            Location current = getMinimumDistanceLocation(unvisited, distance);

            if (current == null) {
                break; // No path exists
            }

            unvisited.remove(current);

            for (Road road : roads) {
                if (road.getStart().equals(current)) {
                    Location neighbor = road.getFinish();
                    double totalDistance = distance.get(current) + road.getLength();

                    if (totalDistance < distance.get(neighbor)) {
                        distance.put(neighbor, totalDistance);
                        previousRoad.put(neighbor, road);
                    }
                }
            }
        }

        // Build the shortest road path
        List<Road> shortestPath = new ArrayList<>();
        Location current = finish;

        while (previousRoad.containsKey(current)) {
            Road road = previousRoad.get(current);
            shortestPath.add(0, road);
            current = road.getStart();
        }

        return shortestPath;
    }

    private Location getMinimumDistanceLocation(Set<Location> locations, Map<Location, Double> distance) {
        Location minLocation = null;
        double minDistance = Double.POSITIVE_INFINITY;

        for (Location location : locations) {
            double dist = distance.get(location);
            if (dist < minDistance) {
                minDistance = dist;
                minLocation = location;
            }
        }

        return minLocation;
    }
}
