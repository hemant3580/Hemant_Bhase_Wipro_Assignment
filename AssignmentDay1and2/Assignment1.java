package AssignmentDay1and2;
import java.util.*;

public class Assignment1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10); list.add(20); list.add(30); list.add(40); list.add(50);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to search: ");
        int num = sc.nextInt();

        if (list.contains(num)) {
            System.out.println(num + " exists in the list.");
        } else {
            System.out.println(num + " does not exist in the list.");
        }
        sc.close();
    }
}
