package AssignmentDay10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment11 {
    // Q11: Read a file using Scanner and display tokens
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("hello.txt"))) {
            while (scanner.hasNext()) {
                String token = scanner.next();
                System.out.println(token);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}
