package org.example.lab3.compulsory;

import java.util.HashMap;
import java.util.Map;

/**
 * Clasa Company are atributele name (unic) si position care descrie relatia person-to-company.
 * Am implementat constructorul si getterele si setterele necesare si am dat override la metoda compareTo().
 */


public class Company implements Comparable<Company>, Node {
    String name;
    String position;
    Map<Node, String> relationships;

    public Company(String name, String position) {
        this.name = name;
        this.position = position;
        this.relationships = new HashMap<>();
    }

    @Override
    public int compareTo(Company o) {
        return this.name.compareTo(o.name);
    }

    public String getName() {
        return this.name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }

    public void setRelationships(Map<Node, String> relationships) {
        this.relationships = relationships;
    }

    public void addRelationship(Person node, String relationship) {
        relationships.put(node, position);
        node.addRelationship(this, position);
    }
}
