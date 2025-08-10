package AssignmentDay8;
import java.util.*;

public class Assignment14 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("Red", "Green", "Blue", "Yellow", "Purple"));
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string to search: ");
        String str = sc.nextLine();
        if (list.contains(str)) {
            System.out.println(str + " found!");
        } else {
            System.out.println(str + " not found!");
        }
        sc.close();
    }
}
