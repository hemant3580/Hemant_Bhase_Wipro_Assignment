package AssignmentDay10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Assignment15 {
    // Q15: Write data into a file using Files.write(), append with StandardOpenOption.APPEND
    public static void main(String[] args) {
        String text = "This is a new line appended.";
        try {
            // Write first (overwrites)
            Files.write(Paths.get("hello.txt"), "First line\n".getBytes());

            // Append text
            Files.write(Paths.get("hello.txt"), text.getBytes(), StandardOpenOption.APPEND);
            System.out.println("Data written and appended successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
