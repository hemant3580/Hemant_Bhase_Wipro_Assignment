package AssignmentDay1and2;
import java.util.*;

public class Assignment19 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1,2,3,4,5));
        LinkedList<Integer> cloned = (LinkedList<Integer>) list.clone();
        System.out.println("Original: " + list);
        System.out.println("Cloned: " + cloned);
    }
}
