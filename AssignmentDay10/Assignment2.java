package AssignmentDay10;

import java.io.File;

public class Assignment2 {
    // Q2: Check whether a file exists at a given path
    public static void main(String[] args) {
        String path = "test.txt";   // example path
        File file = new File(path);
        if (file.exists()) {
            System.out.println("File exists at: " + path);
        } else {
            System.out.println("File does not exist at: " + path);
        }
    }
}
