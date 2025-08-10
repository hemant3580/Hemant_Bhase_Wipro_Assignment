package AssignmentDay9;

// Q18: Append a new student name to existing student.txt (without overwriting)
import java.io.FileWriter;
import java.io.IOException;

public class Assignment18 {

    public static void main(String[] args) {
        String newStudent = "Deepak";

        try (FileWriter fw = new FileWriter("student.txt", true)) { // true = append mode
            fw.write(newStudent + "\n");
            System.out.println("Appended new student to student.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
