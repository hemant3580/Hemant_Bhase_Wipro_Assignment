package AssignmentDay9;

// Q12: Sort Books by ID using Comparable and by title then author using Comparator
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Assignment12 {

    static class Book implements Comparable<Book> {
        int id;
        String title;
        String author;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }

        @Override
        public int compareTo(Book o) {
            return Integer.compare(this.id, o.id);
        }

        @Override
        public String toString() {
            return id + " - " + title + " - " + author;
        }
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(3, "Java Basics", "Alice"));
        books.add(new Book(1, "Data Structures", "Bob"));
        books.add(new Book(2, "Algorithms", "Alice"));

        System.out.println("Sort by ID using Comparable:");
        Collections.sort(books);
        books.forEach(System.out::println);

        System.out.println("\nSort by Title and then Author using Comparator:");
        books.sort(Comparator.comparing((Book b) -> b.title).thenComparing(b -> b.author));
        books.forEach(System.out::println);
    }
}
