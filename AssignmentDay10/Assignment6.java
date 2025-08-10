package AssignmentDay10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Assignment6 {
    // Q6: Count number of lines, words, and characters in a file
    public static void main(String[] args) {
        int lines = 0, words = 0, chars = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("hello.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines++;
                String[] wordArray = line.trim().split("\\s+");
                if (wordArray.length == 1 && wordArray[0].isEmpty()) {
                    // no words in line
                } else {
                    words += wordArray.length;
                }
                chars += line.length();
            }
            System.out.println("Lines: " + lines);
            System.out.println("Words: " + words);
            System.out.println("Characters: " + chars);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
