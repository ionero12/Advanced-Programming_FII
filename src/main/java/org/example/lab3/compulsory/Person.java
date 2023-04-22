package org.example.lab3.compulsory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Clasa Person are atributele name (unic) si relationship care descrie relatia person-to-person.
 * Am implementat constructorul si getterele si setterele necesare si am dat override la metoda compareTo().
 */

public class Person implements Comparable<Person>, Node {
    private String name;
    private String relationship;
    private String birthdate;
    private Map<Node, String> relationships;

    public Person(String name, String relationship, String birthdate) {
        this.name = name;
        this.relationship = relationship;
        this.birthdate = birthdate;
        relationships = new HashMap<>();
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    public String getName() {
        return this.name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setRelationships(Map<Node, String> relationships) {
        this.relationships = relationships;
    }

    public void addRelationship(Node node, String relationship) {
        relationships.put(node, relationship);
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }
}