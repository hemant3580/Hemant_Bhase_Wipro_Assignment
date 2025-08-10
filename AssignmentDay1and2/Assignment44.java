package AssignmentDay1and2;
import java.util.*;

public class Assignment44 {
    public static void main(String[] args) {
        Deque<String> items = new ArrayDeque<>();
        items.addFirst("FrontItem1");
        items.addLast("RearItem1");
        items.addFirst("FrontItem2");
        items.addLast("RearItem2");
        System.out.println("Deque now: " + items);

        // Remove from both ends
        items.removeFirst();
        System.out.println("After removeFirst: " + items);
        items.removeLast();
        System.out.println("After removeLast: " + items);
    }
}
