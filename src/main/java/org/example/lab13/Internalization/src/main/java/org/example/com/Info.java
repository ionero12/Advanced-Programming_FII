package org.example.com;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Info {
    public static void displayInfo(String localeTag) {
        ResourceBundle messages = ResourceBundle.getBundle("res.Messages");

        Locale locale;
        if (localeTag == null) {
            locale = Locale.getDefault();
        } else {
            locale = Locale.forLanguageTag(localeTag);
        }

        System.out.println(messages.getString("info").replace("{0}", locale.getDisplayName()));
        displayLocaleSensitiveInfo(locale);
    }

    private static void displayLocaleSensitiveInfo(Locale locale) {
        ResourceBundle messages = ResourceBundle.getBundle("res.Messages");

        try {
            Currency currency = Currency.getInstance(locale);
            DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);

            System.out.println(messages.getString("country").replace("{0}", locale.getDisplayCountry()));
            System.out.println(messages.getString("language").replace("{0}", locale.getDisplayLanguage()));
            System.out.println(messages.getString("currency").replace("{0}", currency.getCurrencyCode()).replace("{1}", currency.getDisplayName()));
            System.out.println(messages.getString("week.days").replace("{0}", String.join(", ", dateFormatSymbols.getWeekdays())));
            System.out.println(messages.getString("months").replace("{0}", String.join(", ", dateFormatSymbols.getMonths())));
            System.out.println(messages.getString("today").replace("{0}", DateFormat.getDateInstance(DateFormat.LONG, locale).format(new Date())));
        } catch (IllegalArgumentException e) {
            System.out.println("Currency information not available for the current locale.");
        }
    }
}
