package AssignmentDay9;

// Q1: Sort list of Students by rollNo ascending using Comparable
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Assignment1 {

    static class Student implements Comparable<Student> {
        int rollNo;
        String name;
        double marks;

        Student(int rollNo, String name, double marks) {
            this.rollNo = rollNo;
            this.name = name;
            this.marks = marks;
        }

        @Override
        public int compareTo(Student o) {
            return Integer.compare(this.rollNo, o.rollNo);
        }

        @Override
        public String toString() {
            return rollNo + " - " + name + " - " + marks;
        }
    }

    public static void main(String[] args) {
        // Q1
        List<Student> students = new ArrayList<>();
        students.add(new Student(3, "Rahul", 85));
        students.add(new Student(1, "Priya", 92));
        students.add(new Student(2, "Arjun", 78));

        System.out.println("Before sorting (by rollNo):");
        students.forEach(System.out::println);

        Collections.sort(students);

        System.out.println("\nAfter sorting (by rollNo ascending):");
        students.forEach(System.out::println);
    }
}
