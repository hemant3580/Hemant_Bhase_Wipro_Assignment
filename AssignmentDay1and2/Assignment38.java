package AssignmentDay1and2;
import java.util.*;

public class Assignment38 {
    public static void main(String[] args) {
        Queue<String> tasks = new LinkedList<>();
        tasks.add("Check email");
        tasks.add("Finish assignment");
        tasks.add("Call friend");

        System.out.println("Next Task: " + tasks.peek());
        System.out.println("Completed Task: " + tasks.poll());
        System.out.println("Pending Tasks: " + tasks);
    }
}
