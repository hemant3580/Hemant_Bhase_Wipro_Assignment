package AssignmentDay9;

// Q19: Count words and lines in notes.txt
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Assignment19 {

    public static void main(String[] args) {
        int lineCount = 0;
        int wordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("notes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineCount++;
                String[] words = line.trim().split("\\s+");
                if(words.length == 1 && words[0].isEmpty()) continue;
                wordCount += words.length;
            }
            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
