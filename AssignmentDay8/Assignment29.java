package AssignmentDay8;
import java.util.*;

public class Assignment29 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>(Arrays.asList("Delhi", "Mumbai", "Chennai", "Bangalore", "Kolkata"));
        // Remove element
        set.remove("Mumbai");
        // Check if city exists
        if (set.contains("Chennai")) {
            System.out.println("Chennai exists in set.");
        }
        // Clear set
        set.clear();
        System.out.println("After clear: " + set);
    }
}
