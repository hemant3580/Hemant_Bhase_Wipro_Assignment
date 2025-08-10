package AssignmentDay10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Assignment16 {
    // Q16: Walk through directory tree and display file names using Files.walk()
    public static void main(String[] args) {
        try (Stream<java.nio.file.Path> paths = Files.walk(Paths.get("."))) {
            paths.filter(Files::isRegularFile)
                 .forEach(p -> System.out.println(p.toAbsolutePath()));
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
