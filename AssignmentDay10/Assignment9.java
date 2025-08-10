package AssignmentDay10;

import java.io.File;
import java.io.FilenameFilter;

public class Assignment9 {
    // Q9: Display only .txt files from a folder using FilenameFilter
    public static void main(String[] args) {
        File dir = new File(".");
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };

        String[] txtFiles = dir.list(filter);
        if (txtFiles != null) {
            for (String filename : txtFiles) {
                System.out.println(filename);
            }
        } else {
            System.out.println("No .txt files found or directory invalid.");
        }
    }
}
