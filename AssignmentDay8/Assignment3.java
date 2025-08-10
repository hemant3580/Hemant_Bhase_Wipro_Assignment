package AssignmentDay8;
import java.util.*;

public class Assignment3 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(42, 7, 99, 15, 64, 23, 1));
        System.out.println("Before: " + numbers);
        Collections.sort(numbers);
        System.out.println("Sorted: " + numbers);
    }
}
