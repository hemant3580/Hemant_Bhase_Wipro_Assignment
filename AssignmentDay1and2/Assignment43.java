package AssignmentDay1and2;
import java.util.*;

public class Assignment43 {
    public static boolean isPalindrome(String str) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            dq.addLast(c);
        }
        while (dq.size() > 1) {
            if (dq.removeFirst() != dq.removeLast()) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String word = "radar";
        System.out.println(word + " is palindrome? " + isPalindrome(word));
    }
}
