package AssignmentDay1and2;
import java.util.*;

public class Assignment15 {
    public static void main(String[] args) {
        LinkedList<String> cities = new LinkedList<>(Arrays.asList("Delhi", "Mumbai", "Bangalore"));
        ListIterator<String> itr = cities.listIterator();
        System.out.println("Forward:");
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("Reverse:");
        while (itr.hasPrevious()) {
            System.out.println(itr.previous());
        }
    }
}
