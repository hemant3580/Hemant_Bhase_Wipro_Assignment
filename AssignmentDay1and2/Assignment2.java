package AssignmentDay1and2;
import java.util.*;

public class Assignment2 {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Banana", "Mango", "Orange", "Grapes"));
        System.out.println("Current fruits: " + fruits);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter fruit name to remove: ");
        String toRemove = sc.nextLine();

        if (fruits.remove(toRemove)) {
            System.out.println(toRemove + " removed.");
        } else {
            System.out.println(toRemove + " not found.");
        }
        System.out.println("Updated fruits: " + fruits);
        sc.close();
    }
}
