package org.example.com;

import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayLocales {
    public static void displayLocales() {
        ResourceBundle messages = ResourceBundle.getBundle("res.Messages");
        System.out.println(messages.getString("locales"));

        Locale[] availableLocales = Locale.getAvailableLocales();
        for (Locale locale : availableLocales) {
            System.out.println(locale.toLanguageTag() + " - " + locale.getDisplayName());
        }
    }
}