package AssignmentDay8;
import java.util.*;

public class Assignment4 {
    public static void main(String[] args) {
        ArrayList<Character> chars = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E'));
        System.out.println("Original: " + chars);
        Collections.reverse(chars);
        System.out.println("Reversed: " + chars);
    }
}
