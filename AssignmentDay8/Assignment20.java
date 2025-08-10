package AssignmentDay8;
import java.util.*;

public class Assignment20 {
    public static void main(String[] args) {
        Vector<Integer> vec = new Vector<>();
        // Add 5 integers
        vec.add(10);
        vec.add(20);
        vec.add(30);
        vec.add(40);
        vec.add(50);
        // Insert at 3rd position (index 2)
        vec.add(2, 25);
        // Remove 2nd element (index 1)
        vec.remove(1);

        // Display using Enumeration
        Enumeration<Integer> e = vec.elements();
        System.out.println("Vector elements:");
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
    }
}
