package AssignmentDay8;
import java.util.*;

public class Assignment35 {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(45); ts.add(22); ts.add(35); ts.add(67); ts.add(15);

        System.out.println("TreeSet: " + ts);
        System.out.println("First: " + ts.first());
        System.out.println("Last: " + ts.last());

        int val = 35;
        System.out.println("Lower than " + val + ": " + ts.lower(val));
        System.out.println("Higher than " + val + ": " + ts.higher(val));
    }
}
