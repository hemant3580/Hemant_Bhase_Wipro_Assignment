package AssignmentDay10;

import java.io.IOException;
import java.nio.file.*;

public class Assignment13 {
    // Q13: Create, move, delete a file using Files and Paths
    public static void main(String[] args) {
        Path file = Paths.get("tempfile.txt");
        try {
            // Create
            Files.createFile(file);
            System.out.println("File created: " + file.toAbsolutePath());

            // Move (rename)
            Path moved = Paths.get("movedfile.txt");
            Files.move(file, moved, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved/renamed to: " + moved.toAbsolutePath());

            // Delete
            Files.delete(moved);
            System.out.println("File deleted: " + moved.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
