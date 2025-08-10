package AssignmentDay8;
import java.util.*;

public class Assignment24 {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(10);
        stk.push(20);
        stk.push(30);
        stk.push(40);
        stk.push(50);

        // Pop the top element
        if (!stk.isEmpty()) {
            System.out.println("Popped: " + stk.pop());
        }

        // Peek current top
        if (!stk.isEmpty()) {
            System.out.println("Peek: " + stk.peek());
        }

        // Check if empty
        System.out.println("Is stack empty? " + stk.isEmpty());
    }
}
