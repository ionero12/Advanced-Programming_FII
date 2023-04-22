package org.example.lab5.homework;

import org.example.lab5.compulsory.Catalog;
import org.example.lab5.compulsory.Document;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.rmi.server.ExportException;

public class ViewCommand implements Command {
    private Catalog catalog;
    private String id;

    public ViewCommand(Catalog catalog, String id) {
        this.catalog = catalog;
        this.id = id;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void open() throws Exception {
        Document document = catalog.findById(id);
        if(document==null)
            throw new Exception("Document not found");
        try {
            Desktop.getDesktop().open(new File(document.getLocation()));
        } catch (Exception e) {
            throw new Exception("Cannot open document");
        }
    }
}
