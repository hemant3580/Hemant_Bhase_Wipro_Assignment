package AssignmentDay1and2;
import java.util.*;

public class Assignment42 {
    public static PriorityQueue<Integer> mergeQueues(PriorityQueue<Integer> q1, PriorityQueue<Integer> q2) {
        PriorityQueue<Integer> merged = new PriorityQueue<>(q1);
        merged.addAll(q2);
        return merged;
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Arrays.asList(4, 2, 9));
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Arrays.asList(5, 1, 7));

        PriorityQueue<Integer> merged = mergeQueues(pq1, pq2);
        System.out.print("Merged and sorted: ");
        while (!merged.isEmpty()) {
            System.out.print(merged.poll() + " ");
        }
        System.out.println();
    }
}
