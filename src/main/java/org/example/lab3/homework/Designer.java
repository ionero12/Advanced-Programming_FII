package org.example.lab3.homework;

import org.example.lab3.compulsory.Person;

/**
 * Clasa Designer este mostenita din Person si i se mai adauga atributul designerType si setterele/getterele respective.
 */

public class Designer extends Person {
    String designerType;

    public Designer(String name, String relationship, String birthdate, String designerType) {
        super(name, relationship, birthdate);
        this.designerType = designerType;
    }

    public String getDesignerType() {
        return designerType;
    }

    public void setDesignerType(String designerType) {
        this.designerType = designerType;
    }
}

