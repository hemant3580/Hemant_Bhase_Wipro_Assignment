package AssignmentDay10;

import java.io.*;

public class Assignment20 {
    // Q20: Deserialize employee.ser and display object data
    static class Employee implements Serializable {
        int id;
        String name;
        double salary;

        @Override
        public String toString() {
            return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
        }
    }

    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.ser"))) {
            Employee emp = (Employee) ois.readObject();
            System.out.println("Deserialized Employee: " + emp);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
