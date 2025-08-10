package AssignmentDay9;

// Q28: Word search in file notes.txt entered by user
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Assignment28 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word to search: ");
        String word = sc.nextLine();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader("notes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(word)) {
                    found = true;
                    break;
                }
            }
            if (found)
                System.out.println("The word '" + word + "' was found.");
            else
                System.out.println("The word '" + word + "' was NOT found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
