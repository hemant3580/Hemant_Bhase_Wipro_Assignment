package AssignmentDay9;

// Q23: Reverse file content of data.txt into reversed.txt (lines reversed)
import java.io.*;
import java.util.*;

public class Assignment23 {

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.reverse(lines);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("reversed.txt"))) {
            for (String l : lines) {
                bw.write(l);
                bw.newLine();
            }
            System.out.println("Reversed lines written to reversed.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

