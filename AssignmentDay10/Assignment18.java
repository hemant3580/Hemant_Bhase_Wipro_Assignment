package AssignmentDay10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Assignment18 {
    // Q18: Check and print size of a file in bytes using Files.size()
    public static void main(String[] args) {
        try {
            long size = Files.size(Paths.get("hello.txt"));
            System.out.println("Size of hello.txt: " + size + " bytes");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
