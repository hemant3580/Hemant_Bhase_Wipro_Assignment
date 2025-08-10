package AssignmentDay1and2;
import java.util.*;

public class Assignment22 {
    public static void main(String[] args) {
        Vector<Integer> v1 = new Vector<>();
        v1.add(1); v1.add(2); v1.add(3);

        // Copy all elements to v2
        Vector<Integer> v2 = new Vector<>();
        v2.addAll(v1);

        // Compare vectors
        if (v1.equals(v2)) {
            System.out.println("Both vectors are equal.");
        } else {
            System.out.println("Vectors are not equal.");
        }
    }
}
