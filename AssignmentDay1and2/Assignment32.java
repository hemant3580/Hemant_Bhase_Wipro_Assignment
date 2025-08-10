package AssignmentDay1and2;
import java.util.*;

class StudentLHS {
    int id;
    String name;
    StudentLHS(int id, String name) {
        this.id = id; this.name = name;
    }
    @Override
    public int hashCode() { return id; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentLHS)) return false;
        StudentLHS s = (StudentLHS) o;
        return id == s.id && Objects.equals(name, s.name);
    }
    @Override
    public String toString() { return id + ": " + name; }
}

public class Assignment32 {
    public static void main(String[] args) {
        LinkedHashSet<StudentLHS> set = new LinkedHashSet<>();
        set.add(new StudentLHS(1, "Alice"));
        set.add(new StudentLHS(2, "Bob"));
        set.add(new StudentLHS(3, "Charlie"));

        // Try adding a duplicate
        boolean added = set.add(new StudentLHS(2, "Bob")); // Will not be added
        System.out.println("Was duplicate added? " + added);
        for (StudentLHS s : set) {
            System.out.println(s);
        }
    }
}
