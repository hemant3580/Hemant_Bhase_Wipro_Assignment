package AssignmentDay1and2;
import java.util.*;

public class Assignment39 {
    public static List<Integer> getEvenNumbers(Queue<Integer> queue) {
        List<Integer> evens = new ArrayList<>();
        for (Integer n : queue) {
            if (n % 2 == 0) evens.add(n);
        }
        return evens;
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(Arrays.asList(2, 7, 8, 13, 14));
        System.out.println("Even numbers: " + getEvenNumbers(q));
    }
}
