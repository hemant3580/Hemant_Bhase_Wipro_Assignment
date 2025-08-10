package AssignmentDay1and2;
import java.util.*;

public class Assignment27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter decimal number: ");
        int num = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        int n = num;
        if (n == 0) {
            System.out.print("Binary: 0");
        } else {
            while (n > 0) {
                stack.push(n % 2);
                n /= 2;
            }
            System.out.print("Binary: ");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        }
        System.out.println();
        sc.close();
    }
}
