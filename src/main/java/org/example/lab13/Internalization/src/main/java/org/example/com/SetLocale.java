package org.example.com;

import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale {
    public static void setLocale(String localeTag) {
        ResourceBundle messages = ResourceBundle.getBundle("res.Messages");

        Locale locale = Locale.forLanguageTag(localeTag);
        Locale.setDefault(locale);
        System.out.println(messages.getString("locale.set").replace("{0}", locale.getDisplayName()));
    }
}
