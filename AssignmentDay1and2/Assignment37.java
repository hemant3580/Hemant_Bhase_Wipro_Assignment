package AssignmentDay1and2;
import java.util.*;

public class Assignment37 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Ram");
        queue.add("Shyam");
        queue.add("Geeta");
        queue.add("Mohan");
        queue.add("Sita");

        while (!queue.isEmpty()) {
            System.out.println("Queue: " + queue);
            System.out.println("Serving: " + queue.poll());
        }
    }
}
