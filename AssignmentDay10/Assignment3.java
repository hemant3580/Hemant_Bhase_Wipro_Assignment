package AssignmentDay10;

import java.io.FileWriter;
import java.io.IOException;

public class Assignment3 {
    // Q3: Write "Hello, World!" to a file using FileWriter
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("hello.txt")) {
            writer.write("Hello, World!");
            System.out.println("Successfully wrote to hello.txt");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
