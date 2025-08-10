package AssignmentDay10;

import java.io.File;

public class Assignment8 {
    // Q8: List all files in a directory
    public static void main(String[] args) {
        File dir = new File("."); // current directory
        File[] filesList = dir.listFiles();
        if (filesList != null) {
            for (File file : filesList) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Directory is empty or invalid.");
        }
    }
}
