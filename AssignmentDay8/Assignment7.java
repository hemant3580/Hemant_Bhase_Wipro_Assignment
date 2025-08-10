package AssignmentDay8;
import java.util.*;

public class Assignment7 {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>(Arrays.asList("Delhi", "Mumbai", "Bangalore", "Chennai", "Kolkata"));
        System.out.println("Cities:");
        Iterator<String> it = cities.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
