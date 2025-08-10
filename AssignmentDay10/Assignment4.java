package AssignmentDay10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Assignment4 {
    // Q4: Read file content line by line using BufferedReader
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("hello.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
