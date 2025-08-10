package AssignmentDay8;
import java.util.*;

public class Assignment13 {
    public static void main(String[] args) {
        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Dog", "Cat", "Lion", "Tiger", "Horse"));
        System.out.println("Before: " + animals);
        animals.removeFirst();
        System.out.println("After removing first: " + animals);
        animals.removeLast();
        System.out.println("After removing last: " + animals);
        animals.remove("Lion");
        System.out.println("After removing 'Lion': " + animals);
    }
}
