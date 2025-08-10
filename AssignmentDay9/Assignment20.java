package AssignmentDay9;

// Q20: Copy contents from source.txt to destination.txt
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Assignment20 {

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("source.txt");
             FileOutputStream fos = new FileOutputStream("destination.txt")) {

            int ch;
            while ((ch = fis.read()) != -1) {
                fos.write(ch);
            }
            System.out.println("Copied content from source.txt to destination.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
