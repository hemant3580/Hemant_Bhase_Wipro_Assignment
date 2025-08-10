package AssignmentDay1and2;
import java.util.*;

public class Assignment23 {
    public static int sumVector(Vector<Integer> vector) {
        int sum = 0;
        for (Integer i : vector) sum += i;
        return sum;
    }
    public static void main(String[] args) {
        Vector<Integer> nums = new Vector<>();
        nums.add(4); nums.add(8); nums.add(12);
        System.out.println("Sum of vector: " + sumVector(nums));
    }
}
