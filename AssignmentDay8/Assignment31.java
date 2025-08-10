package AssignmentDay8;
import java.util.*;

public class Assignment31 {
    public static void main(String[] args) {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(10); lhs.add(5); lhs.add(20); lhs.add(15); lhs.add(5);
        System.out.println("LinkedHashSet: " + lhs); // preserves insertion order, no duplicates
    }
}
