package org.example.lab5.homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.lab5.compulsory.Catalog;
import org.example.lab5.compulsory.InvalidCatalogException;

import java.io.File;
import java.io.IOException;

public class LoadCommand implements Command {
    private Catalog catalog;
    private String path;

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LoadCommand(Catalog catalog, String path) {
        this.catalog = catalog;
        this.path = path;
    }

    public Catalog load() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(path), Catalog.class);
        } catch (IOException ex) {
            throw new InvalidCatalogException(ex);
        }
    }
}
