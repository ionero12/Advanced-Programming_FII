package org.example.lab3.homework;

import org.example.lab3.compulsory.Company;
import org.example.lab3.compulsory.Person;
import org.example.lab3.compulsory.Node;

import java.util.List;
import java.util.ArrayList;

/**
 * Clasa Network contine o lista de obiecte tip Node si metodele: nodeImportance() si getInfo().
 * nodeImportance() aduna in counter nr de relatii pe care le are (cu alte persoane sau cu compania).
 * getInfo() afiseaza numele persoanei/companiei,dupa ce sunt sortate in functie de importanta.
 */
public class Network {
    List<Node> nodes;

    public Network(List<Node> nodes) {
        this.nodes = new ArrayList<>();
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNodes(Node node) {
        nodes.add(node);
    }

    public int nodeImportance(Node node) {
        int count = 0;
        if (node instanceof Person) {
            Person person = (Person) node;
            count += person.getRelationships().size();
        } else if (node instanceof Company) {
            Company company = (Company) node;
            count += company.getRelationships().size();
        }
        return count;
    }

    public void getInfo() {
        nodes.sort((node1, node2) -> nodeImportance(node2) - nodeImportance(node1));
        for (Node node : nodes) {
            System.out.println(node.getName() + " " + nodeImportance(node));
        }
    }

}
