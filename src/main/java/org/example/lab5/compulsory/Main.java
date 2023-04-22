package org.example.lab5.compulsory;

import org.example.lab5.homework.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Document document1 = new Document("1023", "Capra cu 3 iezi", "https://www.elefant.ro/capra-cu-trei-iezi-poveste-ilustrata_13e008e6-92c9-488b-965e-63c53b596226");
        document1.addTags("Capra cu 3 iezi", "Ion Creanga");
        document1.addTags("1979", "18 mai");

        Document document2 = new Document("1498", "Scufita rosie", "https://www.elefant.ro/scufita-rosie_1fb507c3-7e01-4e0f-842e-7b4a6cbd1956");
        document2.addTags("Scufita rosie", "Fratii Grimm");
        document2.addTags("1980", "2 februarie");

        Document document3 = new Document("341", "Google", "D:\\Facultate\\An 2 Semestru 2\\PA - Programare avansata\\ProgramareAvansata\\src\\main\\java\\org\\example\\lab5\\compulsory\\test");
        document3.addTags("Goole", "-");
        document3.addTags("1990", "8 iunie");

        Catalog catalog = new Catalog("catalog1");
        catalog.addDocuments(document1);
        catalog.addDocuments(document2);


        AddCommand c1=new AddCommand(catalog);
        c1.add(document3);

        ListCommand c2=new ListCommand(catalog);
        c2.print();

        SaveCommand c3= new SaveCommand(catalog, "D:\\Facultate\\An 2 Semestru 2\\PA - Programare avansata\\ProgramareAvansata\\src\\main\\java\\org\\example\\lab5\\compulsory\\test");
        c3.save();

        System.out.println();
        LoadCommand c4=new LoadCommand(catalog, "D:\\Facultate\\An 2 Semestru 2\\PA - Programare avansata\\ProgramareAvansata\\src\\main\\java\\org\\example\\lab5\\compulsory\\test");
        System.out.println("Loaded catalog: " + c4.load());

        ViewCommand c5= new ViewCommand(catalog, "341");
        try {
            c5.open(); //doesnt work -> exception
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}