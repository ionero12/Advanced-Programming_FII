package org.example.lab5.compulsory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private List<Document> documents;
    private String name;

    public Catalog(){

    }
    public Catalog(String name) {
        this.name = name;
        this.documents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public void addDocuments(Document document) {
        documents.add(document);
    }

    public Document findById(String id) {
        for (Document document : documents) {
            if (document.getId().equals(id))
                return document;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "documents=" + documents +
                '}';
    }
}