package AssignmentDay9;

// Q8: Sort Employee by joining date using Comparator
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Assignment8 {

    static class Employee {
        String name;
        LocalDate joinDate;

        Employee(String name, LocalDate joinDate) {
            this.name = name;
            this.joinDate = joinDate;
        }

        @Override
        public String toString() {
            return name + " - " + joinDate;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Raj", LocalDate.of(2019, 5, 10)));
        employees.add(new Employee("Anita", LocalDate.of(2021, 2, 25)));
        employees.add(new Employee("Vikram", LocalDate.of(2018, 11, 5)));

        System.out.println("Before sorting:");
        employees.forEach(System.out::println);

        employees.sort(Comparator.comparing(e -> e.joinDate));

        System.out.println("\nAfter sorting (by joining date ascending):");
        employees.forEach(System.out::println);
    }
}
