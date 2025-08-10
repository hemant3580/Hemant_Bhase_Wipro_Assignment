package AssignmentDay10;

import java.io.*;

public class Assignment7 {
    // Q7: Copy content from one file to another using FileReader & FileWriter
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("hello.txt");
             FileWriter fw = new FileWriter("copy.txt")) {

            int c;
            while ((c = fr.read()) != -1) {
                fw.write(c);
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
