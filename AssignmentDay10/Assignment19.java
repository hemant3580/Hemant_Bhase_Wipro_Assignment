package AssignmentDay10;

import java.io.*;
import java.util.Scanner;

public class Assignment19 {
    // Q19: Serialize a class Employee and store in employee.ser
    static class Employee implements Serializable {
        int id;
        String name;
        double salary;

        Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
        }
    }

    public static void main(String[] args) {
        Employee emp = new Employee(101, "Alice", 55000);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
            oos.writeObject(emp);
            System.out.println("Employee object serialized.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
