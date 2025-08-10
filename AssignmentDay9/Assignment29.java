package AssignmentDay9;

// Q29: Replace word "Java" with "Python" in story.txt and write to updated_story.txt
import java.io.*;

public class Assignment29 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("story.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("updated_story.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                String replaced = line.replaceAll("Java", "Python");
                bw.write(replaced);
                bw.newLine();
            }
            System.out.println("Replaced 'Java' with 'Python' in updated_story.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
