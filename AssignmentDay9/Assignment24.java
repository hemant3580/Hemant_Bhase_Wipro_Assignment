package AssignmentDay9;

// Q24: Store a Student object using serialization in student.ser
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Assignment24 {

    static class Student implements Serializable {
        int id;
        String name;
        double marks;

        Student(int id, String name, double marks) {
            this.id = id;
            this.name = name;
            this.marks = marks;
        }

        @Override
        public String toString() {
            return "Student{" + "id=" + id + ", name='" + name + '\'' + ", marks=" + marks + '}';
        }
    }

    public static void main(String[] args) {
        Student s = new Student(101, "Rahul", 88.5);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            oos.writeObject(s);
            System.out.println("Student object serialized to student.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
