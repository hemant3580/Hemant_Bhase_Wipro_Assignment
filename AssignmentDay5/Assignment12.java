package AssignmentDay5;

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.Arrays;

interface SumCalculator {
    int sum(int a, int b);
}

interface NumberFilter {
    boolean check(int number);
}

interface FactorialCalculator {
    int calculate(int n);
}

public class Assignment12 {
    public static void main(String[] args) {

        SumCalculator add = (a, b) -> a + b;
        System.out.println("Sum: " + add.sum(10, 20));

        Predicate<String> isEmpty = s -> s.isEmpty();
        System.out.println("Is empty: " + isEmpty.test(""));

        NumberFilter isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even: " + isEven.check(4));
        System.out.println("Is 7 even: " + isEven.check(7));

        Function<String, String> toUpper = s -> s.toUpperCase();
        Function<String, String> toLower = s -> s.toLowerCase();
        System.out.println("Upper: " + toUpper.apply("hello"));
        System.out.println("Lower: " + toLower.apply("HELLO"));

        String[] names = {"Bob", "Alexander", "Eve", "Charlie"};
        Arrays.sort(names, (s1, s2) -> s1.length() - s2.length());
        System.out.println("Sorted by length: " + Arrays.toString(names));

        double[] nums = {10.5, 20.2, 5.3, 18.0};
        double sum = Arrays.stream(nums).sum();
        double max = Arrays.stream(nums).max().getAsDouble();
        double avg = Arrays.stream(nums).average().getAsDouble();
        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);
        System.out.println("Avg: " + avg);

        FactorialCalculator fact = n -> {
            int result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }
            return result;
        };
        System.out.println("Factorial of 5: " + fact.calculate(5));
    }
}
