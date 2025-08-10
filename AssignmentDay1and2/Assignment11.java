package AssignmentDay1and2;
import java.util.*;

public class Assignment11 {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>(Arrays.asList(5, 10, 15));
        ll.addFirst(1);
        ll.addLast(20);
        System.out.println("Updated list: " + ll);
    }
}
