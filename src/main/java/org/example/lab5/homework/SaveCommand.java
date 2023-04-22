package org.example.lab5.homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.lab5.compulsory.Catalog;

import java.io.File;
import java.io.IOException;

public class SaveCommand {
    private Catalog catalog;
    private String path;

    public SaveCommand(Catalog catalog, String path) {
        this.catalog = catalog;
        this.path = path;
    }

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

    public void save() throws Exception {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(
                    new File(this.path),
                    this.catalog);
        } catch (Exception e) {
            throw new Exception("Cannot save to this path.");
        }
    }
}
