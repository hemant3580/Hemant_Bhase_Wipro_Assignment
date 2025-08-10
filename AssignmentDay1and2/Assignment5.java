package AssignmentDay1and2;
import java.util.*;

public class Assignment5 {
    public static void main(String[] args) {
        ArrayList<String> subjects = new ArrayList<>(Arrays.asList("Math", "Physics", "Chemistry", "Biology"));
        System.out.println("Before update: " + subjects);

        int idx = subjects.indexOf("Math");
        if (idx != -1) {
            subjects.set(idx, "Statistics");
        }
        System.out.println("After update: " + subjects);
    }
}
