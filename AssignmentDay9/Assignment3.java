package AssignmentDay9;

// Q3: Sort list of Employees by name alphabetically using Comparable
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Assignment3 {

    static class Employee implements Comparable<Employee> {
        String name;
        int id;
        double salary;

        Employee(String name, int id, double salary) {
            this.name = name;
            this.id = id;
            this.salary = salary;
        }

        @Override
        public int compareTo(Employee other) {
            return this.name.compareTo(other.name);
        }

        @Override
        public String toString() {
            return id + " - " + name + " - " + salary;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Zara", 101, 50000));
        employees.add(new Employee("Anil", 102, 45000));
        employees.add(new Employee("Kiran", 103, 47000));

        System.out.println("Before sorting (by name):");
        employees.forEach(System.out::println);

        Collections.sort(employees);

        System.out.println("\nAfter sorting (by name alphabetically):");
        employees.forEach(System.out::println);
    }
}
