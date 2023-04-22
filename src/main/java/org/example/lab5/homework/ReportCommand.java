package org.example.lab5.homework;

import org.example.lab5.compulsory.*;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

public class ReportCommand implements Command {
    private final Catalog catalog;
    private final String outputFilePath;

    public ReportCommand(Catalog catalog, String path) {
        this.catalog = catalog;
        this.outputFilePath = path;
    }

    public void execute() throws InvalidCatalogException {
        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(this.getClass(), "/");
        try {
            Template template = cfg.getTemplate("template.out");
            Map<String, Object> data = new HashMap<>();
            data.put("catalog", catalog);
            data.put("documents", catalog.getDocuments());

            FileWriter writer = new FileWriter(outputFilePath);
            template.process(data, writer);
            writer.close();

            Desktop.getDesktop().open(new File(outputFilePath)); //opening the file created


        } catch (IOException | TemplateException e) {
            throw new InvalidCatalogException(e);
        }
    }
}