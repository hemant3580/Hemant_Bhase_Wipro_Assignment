package AssignmentDay9;

// Q5: Sort list of custom objects with Comparable and display before and after sorting
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Assignment5 {

    static class Person implements Comparable<Person> {
        int id;
        String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            return this.id - o.id;
        }

        @Override
        public String toString() {
            return id + " - " + name;
        }
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(5, "Alice"));
        persons.add(new Person(2, "Bob"));
        persons.add(new Person(3, "Charlie"));

        System.out.println("Before sorting:");
        persons.forEach(System.out::println);

        Collections.sort(persons);

        System.out.println("\nAfter sorting (by id ascending):");
        persons.forEach(System.out::println);
    }
}
