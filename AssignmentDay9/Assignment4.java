package AssignmentDay9;

// Q4: Sort list of Books by bookId descending using Comparable
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Assignment4 {

    static class Book implements Comparable<Book> {
        int bookId;
        String title;

        Book(int bookId, String title) {
            this.bookId = bookId;
            this.title = title;
        }

        @Override
        public int compareTo(Book o) {
            // descending order
            return Integer.compare(o.bookId, this.bookId);
        }

        @Override
        public String toString() {
            return bookId + " - " + title;
        }
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(3, "Java 101"));
        books.add(new Book(1, "Data Structures"));
        books.add(new Book(2, "Algorithms"));

        System.out.println("Before sorting (by bookId):");
        books.forEach(System.out::println);

        Collections.sort(books);

        System.out.println("\nAfter sorting (by bookId descending):");
        books.forEach(System.out::println);
    }
}
