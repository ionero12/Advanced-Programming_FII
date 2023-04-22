package org.example.lab5.compulsory;

import java.util.HashMap;
import java.util.Map;

public class Document {
    private String id;
    private String title;
    private String location;
    private Map<String, String> tags;

    public Document(){

    }
    public Document(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.tags = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    public void addTags(String key, String value) {
        tags.put(key, value);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", tags=" + getTags() +
                '}';
    }
}