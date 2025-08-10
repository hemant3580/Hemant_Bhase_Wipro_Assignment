package AssignmentDay9;

// Q21: Check if report.txt exists and display properties
import java.io.File;

public class Assignment21 {

    public static void main(String[] args) {
        File file = new File("report.txt");
        if (file.exists()) {
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("File Name: " + file.getName());
            System.out.println("Writable: " + file.canWrite());
            System.out.println("Readable: " + file.canRead());
            System.out.println("File Size (bytes): " + file.length());
        } else {
            System.out.println("File report.txt does not exist.");
        }
    }
}
