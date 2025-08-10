package AssignmentDay9;

// Q17: Read from student.txt and display each line (BufferedReader)
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Assignment17 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("student.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
