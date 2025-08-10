package AssignmentDay9;

// Q14: Use Comparator.comparing with method references (Java 8+)
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Assignment14 {

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() { return name; }
        public int getAge() { return age; }

        @Override
        public String toString() {
            return name + " - " + age;
        }
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Anil", 25));
        persons.add(new Person("Zara", 30));
        persons.add(new Person("Kiran", 22));

        System.out.println("Sort by name:");
        persons.sort(Comparator.comparing(Person::getName));
        persons.forEach(System.out::println);

        System.out.println("\nSort by age:");
        persons.sort(Comparator.comparingInt(Person::getAge));
        persons.forEach(System.out::println);
    }
}
