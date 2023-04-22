package org.example.lab5.compulsory;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CatalogUtil {
    private Catalog catalog;

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public CatalogUtil(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public String toString() {
        return "CatalogUtil{" +
                "catalog=" + catalog +
                '}';
    }

   /* //public void addDocuments(Document document) {
        catalog.addDocuments(document);
    }*/

    /*public void save(Catalog catalog, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);
    }*/
    /*public Catalog load(String path) throws InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(path), Catalog.class);
        } catch (IOException ex) {
            throw new InvalidCatalogException(ex);
        }
    }*/
}
