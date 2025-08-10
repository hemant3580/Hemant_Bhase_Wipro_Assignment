package AssignmentDay10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Assignment17 {
    // Q17: Copy a file using Files.copy() with REPLACE_EXISTING option
    public static void main(String[] args) {
        try {
            Files.copy(Paths.get("hello.txt"), Paths.get("hello_copy.txt"),
                    StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
