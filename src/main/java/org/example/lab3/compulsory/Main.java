package org.example.lab3.compulsory;

import org.example.lab3.homework.Designer;
import org.example.lab3.homework.Network;
import org.example.lab3.homework.Programmer;

import java.util.ArrayList;
import java.util.List;

/**
 * In clasa Main se creeaza mai multe obiecte de tip Person (Programmer si Designer) si Company, si se afiseaza in functie
 * de numarul de conexiuni/relatii intre persoane/persoane-companie.
 */
public class Main {
    public static void main(String[] args) {

        List<Node> nodes = new ArrayList<>();
        Person maria = new Programmer("Maria", "friendship", "10.01.1998", "Java");
        Person diana = new Designer("Diana", "marriage", "02.04.2000", "interior");
        Person david = new Designer("David", "marriage", "22.09.2000", "fashion");
        Person alex = new Programmer("Alex", "friendship", "13.12.1985", "C++");
        Person mihai = new Programmer("Mihai", "friendship", "25.01.2002", "JavaScript");
        Company microsoft = new Company("Microsoft", "software engineering");
        Company facebook = new Company("Facebook", "frontend developer");
        Company orange = new Company("Orange", "designer");
        diana.addRelationship(david, "marriage");
        david.addRelationship(diana, "marriage");
        maria.addRelationship(alex, "friendship");
        mihai.addRelationship(david, "friendship");
        mihai.addRelationship(maria, "friendship");
        microsoft.addRelationship(maria, "software engineer");
        orange.addRelationship(diana, "interior designer");
        orange.addRelationship(david, "fashion designer");
        facebook.addRelationship(alex, "full-stack developer");
        facebook.addRelationship(mihai, "back-end developer");
        Network network = new Network(nodes);
        network.addNodes(maria);
        network.addNodes(diana);
        network.addNodes(david);
        network.addNodes(alex);
        network.addNodes(mihai);
        network.addNodes(facebook);
        network.addNodes(microsoft);
        network.addNodes(orange);
        network.getInfo();
    }
}
