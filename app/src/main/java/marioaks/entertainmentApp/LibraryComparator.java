package marioaks.entertainmentApp;

import java.util.Comparator;

public class LibraryComparator {
    static final Comparator<LibraryEntry> BY_NAME = new Comparator<LibraryEntry>() {
        public int compare(LibraryEntry entry, LibraryEntry entry2) {
            return entry.name.compareTo(entry2.name);
        }
    };

    static final Comparator<LibraryEntry> BY_GENRE = new Comparator<LibraryEntry>() {
        public int compare(LibraryEntry entry, LibraryEntry entry2) {
            return entry.genre.compareTo(entry2.genre);
        }
    };

    static final Comparator<LibraryEntry> BY_DATE_COMPLETED = new Comparator<LibraryEntry>() {
        public int compare(LibraryEntry entry, LibraryEntry entry2) {
            return entry2.completed.compareTo(entry.completed);
        }
    };

    static final Comparator<LibraryEntry> BY_RATING = new Comparator<LibraryEntry>() {
        public int compare(LibraryEntry entry, LibraryEntry entry2) {
            double comp = entry2.rating - entry.rating;
            if (comp > 0) return 1;
            else if (comp < 0) return -1;
            else return 0;
        }
    };
}
