package AssignmentDay9;

// Q22: Create a file and accept user input to write to userinput.txt
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Assignment22 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text (single line) to write into userinput.txt:");
        String input = sc.nextLine();

        try (FileWriter fw = new FileWriter("userinput.txt")) {
            fw.write(input);
            System.out.println("Written input to userinput.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
