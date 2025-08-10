package AssignmentDay1and2;
import java.util.*;

public class Assignment12 {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        System.out.println("Before: " + names);
        names.add(2, "David");
        System.out.println("After: " + names);
    }
}
