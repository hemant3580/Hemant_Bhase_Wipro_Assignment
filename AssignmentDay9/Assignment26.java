package AssignmentDay9;

// Q26: Print all files (not directories) inside folder path given by user
import java.io.File;
import java.util.Scanner;

public class Assignment26 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter folder path: ");
        String folderPath = sc.nextLine();

        File folder = new File(folderPath);
        if (folder.isDirectory()) {
            File[] files = folder.listFiles(file -> file.isFile());
            if (files != null && files.length > 0) {
                System.out.println("Files in directory:");
                for (File f : files) {
                    System.out.println(f.getName());
                }
            } else {
                System.out.println("No files found in directory.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }
        sc.close();
    }
}
