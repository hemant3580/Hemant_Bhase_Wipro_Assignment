package AssignmentDay10;

import java.io.*;

public class Assignment12 {
    // Q12: Search specific word in file and count occurrences
    public static void main(String[] args) {
        String targetWord = "Hello";
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("hello.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String w : words) {
                    if (w.equals(targetWord)) {
                        count++;
                    }
                }
            }
            System.out.println("Word \"" + targetWord + "\" found " + count + " times.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
