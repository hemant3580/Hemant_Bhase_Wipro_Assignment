package AssignmentDay1and2;
import java.util.*;

class Book {
    int id;
    String title;
    String author;
    Book(int id, String title, String author) {
        this.id = id; this.title = title; this.author = author;
    }
}

public class Assignment18 {
    public static void main(String[] args) {
        LinkedList<Book> books = new LinkedList<>();
        books.add(new Book(1, "Java Basics", "Alice"));
        books.add(new Book(2, "DSA", "Bob"));
        books.add(new Book(3, "OOP", "Charlie"));
        for (Book b : books) {
            System.out.println("Id: " + b.id + ", Title: " + b.title + ", Author: " + b.author);
        }
    }
}
