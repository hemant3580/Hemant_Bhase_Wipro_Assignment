package AssignmentDay9;

// Q13: Menu-driven program to sort Employees by name, salary or department using Comparators
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Assignment13 {

    static class Employee {
        String name;
        double salary;
        String department;

        Employee(String name, double salary, String department) {
            this.name = name;
            this.salary = salary;
            this.department = department;
        }

        @Override
        public String toString() {
            return name + " - " + salary + " - " + department;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 60000, "HR"));
        employees.add(new Employee("Bob", 55000, "Finance"));
        employees.add(new Employee("Charlie", 70000, "IT"));

        Scanner sc = new Scanner(System.in);
        System.out.println("Sort Employees by:");
        System.out.println("1. Name");
        System.out.println("2. Salary");
        System.out.println("3. Department");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                employees.sort(Comparator.comparing(e -> e.name));
                break;
            case 2:
                employees.sort(Comparator.comparingDouble(e -> e.salary));
                break;
            case 3:
                employees.sort(Comparator.comparing(e -> e.department));
                break;
            default:
                System.out.println("Invalid choice");
                sc.close();
                return;
        }

        System.out.println("Sorted Employees:");
        employees.forEach(System.out::println);
        sc.close();
    }
}
