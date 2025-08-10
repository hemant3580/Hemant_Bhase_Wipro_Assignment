package AssignmentDay10;

import java.io.FileWriter;
import java.io.IOException;

public class Assignment5 {
    // Q5: Append a line of text to an existing file
    public static void main(String[] args) {
        String textToAppend = "This is an appended line.";
        try (FileWriter fw = new FileWriter("hello.txt", true)) { // true for append mode
            fw.write("\n" + textToAppend);
            System.out.println("Successfully appended to hello.txt");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
