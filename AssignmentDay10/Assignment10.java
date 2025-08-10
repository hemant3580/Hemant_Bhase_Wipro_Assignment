package AssignmentDay10;

import java.io.*;

public class Assignment10 {
    // Q10: Serialize and deserialize a Student object
    static class Student implements Serializable {
        int id;
        String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return "Student{id=" + id + ", name='" + name + "'}";
        }
    }

    public static void main(String[] args) {
        String filename = "student.ser";

        // Serialization
        Student s = new Student(101, "Rahul");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(s);
            System.out.println("Student object serialized.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Student s2 = (Student) ois.readObject();
            System.out.println("Student object deserialized: " + s2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
