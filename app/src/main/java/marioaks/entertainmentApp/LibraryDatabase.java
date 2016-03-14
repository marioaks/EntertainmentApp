package marioaks.entertainmentApp;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class LibraryDatabase {
    private static TreeSet<LibraryEntry> library;
    private static LibraryDatabase instance = new LibraryDatabase();

    private LibraryDatabase() {
        library = new TreeSet<LibraryEntry>(LibraryComparator.BY_NAME);
        initDummyEntries();
    }

    public static LibraryDatabase getInstance() {
        return instance;
    }

    public void add(LibraryEntry entry) {
        library.add(entry);
    }

    public List<LibraryEntry> getAll() {
        return new ArrayList<LibraryEntry>(library);
    }

    private List<LibraryEntry> getHelper(String genre) {
        ArrayList<LibraryEntry> output = new ArrayList<LibraryEntry>();
        for (LibraryEntry entry : library) {
            if (entry.type.equals(genre)) {
                output.add(entry);
            }
        }
        return output;
    }

    public List<LibraryEntry> getBooks() {
        return getHelper("Book");
    }

    public List<LibraryEntry> getMoviesandTV() {
        return getHelper("Movie/TV Show");
    }

    public List<LibraryEntry> getMusic() {
        return getHelper("Music");
    }

    private void initDummyEntries() {
        library.add(new LibraryEntry("Star Wars Episode III: Revenge of the Sith", "Movie/TV Show",
                "sci-fi", 3.5, ""));
        library.add(new LibraryEntry("Inside Out", "Movie/TV Show", "animation", 4, ""));
        library.add(new LibraryEntry("Transformers: Age of Extinction", "Movie/TV Show",
                "sci-fi", 0.5, ""));
        library.add(new LibraryEntry("Skyfall", "Movie/TV Show", "action", 2.5, ""));
        library.add(new LibraryEntry("Star Wars Episode VII: The Force Awakens", "Movie/TV Show",
                "sci-fi", 3.5, ""));
        library.add(new LibraryEntry("Monty Python and the Holy Grail", "Movie/TV Show",
                "comedy", 3.5, ""));
        library.add(new LibraryEntry("House of Cards", "Movie/TV Show", "drama", 3, ""));
        library.add(new LibraryEntry("Tuck Everlasting", "Book", "romance", 3, ""));
        library.add(new LibraryEntry("It's Kind of a Funny Story", "Book", "young adult", 4, ""));
        library.add(new LibraryEntry("Jane Eyre", "Book", "romance", 2.5, ""));
        library.add(new LibraryEntry("To Kill a Mockingbird", "Book", "classic", 3.5, ""));
        library.add(new LibraryEntry("The Odyssey", "Book", "epic", 3.5, ""));
        library.add(new LibraryEntry("Sleeping Freshmen Never Lie", "Book", "young adult", 3.5, ""));
        library.add(new LibraryEntry("Hybrid Theory", "Music", "nu-metal", 3, ""));
        library.add(new LibraryEntry("1989", "Music", "pop", 4, ""));
        library.add(new LibraryEntry("Paramore", "Music", "pop rock", 3.5, ""));
        library.add(new LibraryEntry("ANTI", "Music", "R&B", 3.5, ""));
        library.add(new LibraryEntry("Never Say Never", "Music", "pop", 2, ""));
    }
}
