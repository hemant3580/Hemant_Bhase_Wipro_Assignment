package AssignmentDay1and2;
import java.util.*;

public class Assignment9 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("Alpha", "Bravo", "Charlie"));
        ArrayList<String> list2 = new ArrayList<>();
        list2.addAll(list1);

        System.out.println("First: " + list1);
        System.out.println("Second (copy): " + list2);
    }
}
