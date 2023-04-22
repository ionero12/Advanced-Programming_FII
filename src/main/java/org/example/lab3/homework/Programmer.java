package org.example.lab3.homework;

import org.example.lab3.compulsory.Person;

/**
 * Clasa Programmer este mostenita din Person si i se mai adauga atributul programmingLanguage si setterele/getterele respective.
 */

public class Programmer extends Person {
    String programmingLanguage;

    public Programmer(String name, String relationship, String birthdate, String programmingLanguage) {
        super(name, relationship, birthdate);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }
}