package AssignmentDay9;

// Q16: Create and Write to a file student.txt with 5 student names (FileWriter)
import java.io.FileWriter;
import java.io.IOException;

public class Assignment16 {

    public static void main(String[] args) {
        String[] students = {"Rahul", "Priya", "Amit", "Sonia", "Arjun"};

        try (FileWriter writer = new FileWriter("student.txt")) {
            for (String name : students) {
                writer.write(name + "\n");
            }
            System.out.println("student.txt created and names written.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
