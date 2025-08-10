package AssignmentDay8;
import java.util.*;

class Patient {
    String name;
    int severityLevel;
    Patient(String name, int severityLevel) {
        this.name = name;
        this.severityLevel = severityLevel;
    }
    @Override
    public String toString() {
        return name + " (" + severityLevel + ")";
    }
}

public class Assignment40 {
    public static void main(String[] args) {
        PriorityQueue<Patient> pq = new PriorityQueue<>((a, b) -> b.severityLevel - a.severityLevel);
        pq.add(new Patient("Amit", 3));
        pq.add(new Patient("Ria", 5));
        pq.add(new Patient("Sona", 1));
        pq.add(new Patient("Vijay", 4));

        while (!pq.isEmpty()) {
            System.out.println("Serving: " + pq.poll());
        }
    }
}
