package org.example.lab5.homework;

import org.example.lab5.compulsory.Catalog;

import java.util.List;

public class ListCommand implements Command {
    private Catalog catalog;

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public void print() {
        System.out.println(catalog.getDocuments());
    }
}
