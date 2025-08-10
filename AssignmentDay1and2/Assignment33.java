package AssignmentDay1and2;
import java.util.*;

public class Assignment33 {
    public static void main(String[] args) {
        LinkedHashSet<String> set1 = new LinkedHashSet<>(Arrays.asList("A", "B", "C"));
        LinkedHashSet<String> set2 = new LinkedHashSet<>(Arrays.asList("B", "C", "D"));

        LinkedHashSet<String> merged = new LinkedHashSet<>(set1);
        merged.addAll(set2);
        System.out.println("Merged LinkedHashSet: " + merged);
    }
}
