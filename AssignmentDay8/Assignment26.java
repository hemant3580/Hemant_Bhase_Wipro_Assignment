package AssignmentDay8;
import java.util.*;

public class Assignment26 {
    public static boolean isBalanced(String expr) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expr.toCharArray()) {
            if (ch == '(') stack.push(ch);
            if (ch == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String expr = "(a+b)*(c-d)";
        if (isBalanced(expr)) {
            System.out.println("Valid expression");
        } else {
            System.out.println("Invalid expression");
        }
    }
}
