package AssignmentDay9;

// Q15: Use TreeSet with custom comparator to sort Persons by age
import java.util.Comparator;
import java.util.TreeSet;

public class Assignment15 {

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " - " + age;
        }
    }

    public static void main(String[] args) {
        TreeSet<Person> personsByAge = new TreeSet<>(Comparator.comparingInt(p -> p.age));
        personsByAge.add(new Person("Rahul", 28));
        personsByAge.add(new Person("Priya", 25));
        personsByAge.add(new Person("Arjun", 30));

        System.out.println("Persons sorted by age using TreeSet:");
        personsByAge.forEach(System.out::println);
    }
}
