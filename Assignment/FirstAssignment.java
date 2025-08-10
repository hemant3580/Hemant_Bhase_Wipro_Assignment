package Assignment;

public class FirstAssignment {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        // 1. Printing even numbers from 2 to 50
		        System.out.println("1. Even numbers from 2 to 50:");
		        for (int i = 2; i <= 50; i += 2) {
		            System.out.print(i + " ");
		        }
		        System.out.println("\n");

		        // 2. Printing square of numbers from 1 to 10
		        System.out.println("2. Square of numbers from 1 to 10:");
		        for (int i = 1; i <= 10; i++) {
		            System.out.println(i + "^2 = " + (i * i));
		        }
		        System.out.println();

		        // 3. Calculating sum of first 50 numbers
		        int sum = 0;
		        for (int i = 1; i <= 50; i++) {
		            sum += i;
		        }
		        System.out.println("3. Sum of first 50 numbers: " + sum + "\n");

		        // 4. Printing multiplication table for 17
		        System.out.println("4. Multiplication table of 17:");
		        for (int i = 1; i <= 10; i++) {
		            System.out.println("17 x " + i + " = " + (17 * i));
		        }
		        System.out.println();

		        // 5. Printing reverse numbers from 20 to 1
		        System.out.println("5. Reverse numbers from 20 to 1:");
		        for (int i = 20; i >= 1; i--) {
		            System.out.print(i + " ");
		        }
		        System.out.println("\n");

		        // 6. Printing factorial of a number (e.g. 5)
		        int num = 5;
		        long fact = 1;
		        for (int i = 1; i <= num; i++) {
		            fact *= i;
		        }
		        System.out.println("6. Factorial of " + num + " is: " + fact + "\n");

		        // 7. Checking if a number is prime (e.g. 29)
		        int checkNum = 29;
		        boolean isPrime = true;
		        if (checkNum < 2) isPrime = false;
		        else {
		            for (int i = 2; i <= Math.sqrt(checkNum); i++) {
		                if (checkNum % i == 0) {
		                    isPrime = false;
		                    break;
		                }
		            }
		        }
		        System.out.println("7. Is " + checkNum + " a prime number? " + isPrime + "\n");

		        // 8. Printing pyramid pattern
		        System.out.println("8. Pyramid pattern:");
		        int rows = 5;
		        for (int i = 1; i <= rows; i++) {
		            for (int j = i; j < rows; j++) {
		                System.out.print(" ");
		            }
		            for (int k = 1; k <= i; k++) {
		                System.out.print("* ");
		            }
		            System.out.println();
		        }
		        System.out.println();

		        // 9. Printing diamond shape using * sign
		        System.out.println("9. Diamond shape:");
		        int n = 5;
		        // Upper half
		        for (int i = 1; i <= n; i++) {
		            for (int j = i; j < n; j++) System.out.print(" ");
		            for (int k = 1; k <= (2 * i - 1); k++) System.out.print("*");
		            System.out.println();
		        }
		        // Lower half
		        for (int i = n - 1; i >= 1; i--) {
		            for (int j = n; j > i; j--) System.out.print(" ");
		            for (int k = 1; k <= (2 * i - 1); k++) System.out.print("*");
		            System.out.println();
		        }
		        System.out.println();

		        // 10. Fibonacci series up to 10 terms (starting 1, 2, 3, 5...)
		        System.out.println("10. Fibonacci series (10 terms):");
		        int a = 1, b = 2;
		        System.out.print(a + " " + b + " ");
		        for (int i = 3; i <= 10; i++) {
		            int c = a + b;
		            System.out.print(c + " ");
		            a = b;
		            b = c;
		        }
		        System.out.println("\n");

		        // 11. Counting total digits in a number (e.g. 6785)
		        int number = 6785;
		        int count = 0, temp = number;
		        while (temp > 0) {
		            count++;
		            temp /= 10;
		        }
		        System.out.println("11. Total digits in " + number + " = " + count + "\n");

		        // 12. Checking palindrome number (e.g. 121)
		        int original = 121, reversed = 0, temp2 = original;
		        while (temp2 != 0) {
		            int digit = temp2 % 10;
		            reversed = reversed * 10 + digit;
		            temp2 /= 10;
		        }
		        System.out.println("12. Is " + original + " a palindrome? " + (original == reversed) + "\n");

		        // 13. Sum of digits of number (e.g. 6785 = 6+7+8+5)
		        int digitSum = 0, temp3 = number;
		        while (temp3 != 0) {
		            digitSum += temp3 % 10;
		            temp3 /= 10;
		        }
		        System.out.println("13. Sum of digits of " + number + " = " + digitSum);
		    }
		}

