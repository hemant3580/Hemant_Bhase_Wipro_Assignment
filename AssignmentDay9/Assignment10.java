package AssignmentDay9;

// Q10: Sort list of strings by length using anonymous inner class
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Assignment10 {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("banana");
        words.add("apple");
        words.add("cat");
        words.add("elephant");

        System.out.println("Before sorting:");
        words.forEach(System.out::println);

        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        System.out.println("\nAfter sorting (by length ascending):");
        words.forEach(System.out::println);
    }
}
