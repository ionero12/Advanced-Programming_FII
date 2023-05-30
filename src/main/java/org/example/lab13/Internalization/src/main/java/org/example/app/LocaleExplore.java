package org.example.app;

import java.util.ResourceBundle;
import java.util.Scanner;

import org.example.com.DisplayLocales;
import org.example.com.Info;
import org.example.com.SetLocale;

public class LocaleExplore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResourceBundle messages = ResourceBundle.getBundle("res.Messages");

        while (true) {
            System.out.print(messages.getString("prompt") + " ");
            String command = scanner.nextLine();

            if (command.equals("locales")) {
                DisplayLocales.displayLocales();
            } else if (command.startsWith("locale.set ")) {
                String[] parts = command.split(" ");
                if (parts.length == 2) {
                    SetLocale.setLocale(parts[1]);
                } else {
                    System.out.println(messages.getString("invalid"));
                }
            } else if (command.equals("info")) {
                Info.displayInfo(null);
            } else if (command.startsWith("info ")) {
                String[] parts = command.split(" ");
                if (parts.length == 2) {
                    Info.displayInfo(parts[1]);
                } else {
                    System.out.println(messages.getString("invalid"));
                }
            } else {
                System.out.println(messages.getString("invalid"));
            }
        }
    }
}