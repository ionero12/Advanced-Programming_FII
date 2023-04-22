package org.example.lab5.homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.lab5.compulsory.Catalog;
import org.example.lab5.compulsory.Document;

import java.io.File;
import java.io.IOException;

public class AddCommand implements Command {
    private Catalog catalog;

    public AddCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public void add(Document doc) {
        catalog.addDocuments(doc);
    }
}
