package AssignmentDay8;
import java.util.*;

public class Assignment36 {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>(Collections.reverseOrder());
        ts.add("Banana");
        ts.add("Apple");
        ts.add("Mango");
        ts.add("Peach");

        System.out.println("TreeSet (reverse order): " + ts);
    }
}
