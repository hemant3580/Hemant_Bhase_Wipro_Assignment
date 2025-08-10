package AssignmentDay1and2;
import java.util.*;

public class Assignment45 {
    public static void main(String[] args) {
        Deque<String> backStack = new ArrayDeque<>();
        Deque<String> forwardStack = new ArrayDeque<>();
        String current = "Home";

        // Visit some pages
        backStack.push(current); current = "Page1";
        backStack.push(current); current = "Page2";

        // Go back
        forwardStack.push(current); current = backStack.pop();
        System.out.println("Went back, now at: " + current);

        // Go forward
        if (!forwardStack.isEmpty()) {
            backStack.push(current); current = forwardStack.pop();
            System.out.println("Went forward, now at: " + current);
        }
    }
}
