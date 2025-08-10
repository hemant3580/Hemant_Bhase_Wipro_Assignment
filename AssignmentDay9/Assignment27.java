package AssignmentDay9;

// Q27: Delete a file if exists (file name input from user)
import java.io.File;
import java.util.Scanner;

public class Assignment27 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name to delete: ");
        String fileName = sc.nextLine();

        File file = new File(fileName);
        if (file.exists()) {
            boolean deleted = file.delete();
            if (deleted) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete file.");
            }
        } else {
            System.out.println("File does not exist.");
        }
        sc.close();
    }
}
