package AssignmentDay9;

// Q6: Sort list of students by marks descending using Comparator (lambda)
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Assignment6 {

    static class Student {
        String name;
        double marks;

        Student(String name, double marks) {
            this.name = name;
            this.marks = marks;
        }

        @Override
        public String toString() {
            return name + " - " + marks;
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Rahul", 85));
        students.add(new Student("Priya", 92));
        students.add(new Student("Arjun", 78));

        System.out.println("Before sorting:");
        students.forEach(System.out::println);

        students.sort((s1, s2) -> Double.compare(s2.marks, s1.marks)); // descending by marks

        System.out.println("\nAfter sorting (by marks descending):");
        students.forEach(System.out::println);
    }
}
