package AssignmentDay1and2;
import java.util.*;

class Student {
    int id;
    String name;
    double marks;
    Student(int id, String name, double marks) {
        this.id = id; this.name = name; this.marks = marks;
    }
}

public class Assignment8 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Rahul", 85.5));
        students.add(new Student(2, "Priya", 92.0));
        students.add(new Student(3, "Arjun", 78.5));

        for (Student s : students) {
            System.out.println("ID: " + s.id + ", Name: " + s.name + ", Marks: " + s.marks);
        }
    }
}
