package AssignmentDay9;

// Q11: Student implements Comparable (sort by name), Comparator for marks
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Assignment11 {

    static class Student implements Comparable<Student> {
        String name;
        double marks;

        Student(String name, double marks) {
            this.name = name;
            this.marks = marks;
        }

        @Override
        public int compareTo(Student o) {
            return this.name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return name + " - " + marks;
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Raj", 78));
        students.add(new Student("Seema", 92));
        students.add(new Student("Anil", 85));

        System.out.println("Sort by name using Comparable:");
        Collections.sort(students);
        students.forEach(System.out::println);

        System.out.println("\nSort by marks using Comparator:");
        students.sort(Comparator.comparingDouble(s -> s.marks));
        students.forEach(System.out::println);
    }
}
