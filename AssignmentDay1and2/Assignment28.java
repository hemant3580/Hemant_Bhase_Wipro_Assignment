package AssignmentDay1and2;
import java.util.*;

public class Assignment28 {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi"); cities.add("Mumbai"); cities.add("Chennai");
        cities.add("Bangalore"); cities.add("Kolkata");

        // Try adding duplicate
        boolean added = cities.add("Delhi");
        System.out.println("Was duplicate 'Delhi' added? " + added);

        // Iterate using Iterator
        Iterator<String> it = cities.iterator();
        System.out.println("Cities:");
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
