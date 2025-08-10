package AssignmentDay10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Assignment14 {
    // Q14: Read all lines of file using Files.readAllLines() and print
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("hello.txt"));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
