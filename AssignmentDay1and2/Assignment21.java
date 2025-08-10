package AssignmentDay1and2;
import java.util.*;

public class Assignment21 {
    public static void main(String[] args) {
        Vector<String> names = new Vector<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("Diana");

        // Check if a specific name exists
        String search = "Charlie";
        if (names.contains(search)) {
            System.out.println(search + " found in vector.");
        } else {
            System.out.println(search + " not in vector.");
        }

        // Replace "Bob" with "Brian"
        int idx = names.indexOf("Bob");
        if (idx != -1) {
            names.set(idx, "Brian");
        }

        // Clear all elements
        names.clear();
        System.out.println("Vector after clearing: " + names);
    }
}
