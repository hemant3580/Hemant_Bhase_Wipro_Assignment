package AssignmentDay1and2;
import java.util.*;

public class Assignment6 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(18, 22, 35, 44, 56));
        System.out.println("Before: " + nums);
        nums.clear();
        System.out.println("After clear: " + nums);
        System.out.println("Size: " + nums.size());
    }
}
