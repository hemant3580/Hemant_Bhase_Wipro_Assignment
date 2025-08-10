package AssignmentDay1and2;
import java.util.*;

public class Assignment30 {
    public static String getMax(HashSet<String> set) {
        String max = null;
        for (String s : set) {
            if (max == null || s.compareTo(max) > 0) {
                max = s;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>(Arrays.asList("Delhi", "Mumbai", "Chennai", "Bangalore", "Kolkata"));
        System.out.println("Maximum (lexical): " + getMax(set));
    }
}
