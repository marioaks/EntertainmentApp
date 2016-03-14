package marioaks.entertainmentApp;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class LibraryEntry {

    String name;
    String type;
    String genre;
    double rating;
    String review;
    Calendar completed;

    public LibraryEntry(String name, String type, String genre, double rating, String review) {
        this.name = name;
        this.type = type;
        this.genre = genre;
        this.rating = rating;
        this.review = review;
        completed = new GregorianCalendar();
    }
}
