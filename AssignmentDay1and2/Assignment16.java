package AssignmentDay1and2;
import java.util.*;

public class Assignment16 {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>(Arrays.asList(3, 8, 1, 6, 4));
        Collections.sort(numbers);
        System.out.println("Sorted: " + numbers);
    }
}
