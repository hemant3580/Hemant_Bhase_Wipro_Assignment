package Assignment;
import java.util.*;
public class SecondAssignmentArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int[] arr = {5, 8, 3, 8, 4, 2, 5, 9, 3};

		System.out.println("1.");
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("Sum: " + sum);

		System.out.println("2.");
		int even = 0, odd = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				even++;
			} else {
				odd++;
			}
		}
		System.out.println("Even: " + even + ", Odd: " + odd);

		System.out.println("3.");
		int max = arr[0];
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println("Max: " + max + ", Min: " + min);

		System.out.println("4.");
		int highest = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > highest) {
				highest = arr[i];
			}
		}
		int second = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != highest && arr[i] > second) {
				second = arr[i];
			}
		}
		System.out.println("Second Highest: " + second);

		System.out.println("5.");
		System.out.print("Enter number to search: ");
		int key = sc.nextInt();
		boolean found = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				found = true;
				break;
			}
		}
		System.out.println(found ? "Found" : "Not Found");

		System.out.println("6.");
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		System.out.println("7.");
		for (int i = 0; i < arr.length; i++) {
			boolean isDuplicate = false;
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					isDuplicate = true;
					break;
				}
			}
			if (!isDuplicate) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();

		System.out.println("8.");
		int[] copied = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			copied[i] = arr[i];
		}
		for (int i = 0; i < copied.length; i++) {
			System.out.print(copied[i] + " ");
		}
		System.out.println();

		System.out.println("9.");
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		System.out.println("10.");
		for (int i = 0; i < arr.length; i++) {
			boolean isPrime = true;
			if (arr[i] <= 1) {
				isPrime = false;
			} else {
				for (int j = 2; j < arr[i]; j++) {
					if (arr[i] % j == 0) {
						isPrime = false;
						break;
					}
				}
			}
			if (isPrime) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();

		System.out.println("11.");
		boolean[] visited = new boolean[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				int count = 1;
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[i] == arr[j]) {
						visited[j] = true;
						count++;
					}
				}
				System.out.println(arr[i] + " = " + count);
			}
		}

		System.out.println("12.");
		int[] rotateArr = {1, 2, 3, 4, 5};
		int last = rotateArr[rotateArr.length - 1];
		for (int i = rotateArr.length - 1; i > 0; i--) {
			rotateArr[i] = rotateArr[i - 1];
		}
		rotateArr[0] = last;
		for (int i = 0; i < rotateArr.length; i++) {
			System.out.print(rotateArr[i] + " ");
		}
		System.out.println();

		System.out.println("13.");
		int[] a1 = {1, 4, 6};
		int[] a2 = {2, 5, 3};
		int[] merged = new int[a1.length + a2.length];
		for (int i = 0; i < a1.length; i++) {
			merged[i] = a1[i];
		}
		for (int i = 0; i < a2.length; i++) {
			merged[a1.length + i] = a2[i];
		}
		for (int i = 0; i < merged.length; i++) {
			for (int j = i + 1; j < merged.length; j++) {
				if (merged[i] > merged[j]) {
					int temp = merged[i];
					merged[i] = merged[j];
					merged[j] = temp;
				}
			}
		}
		for (int i = 0; i < merged.length; i++) {
			System.out.print(merged[i] + " ");
		}
		System.out.println();

		System.out.println("14.");
		int[] pal = {1, 2, 3, 2, 1};
		boolean isPal = true;
		for (int i = 0; i < pal.length / 2; i++) {
			if (pal[i] != pal[pal.length - 1 - i]) {
				isPal = false;
				break;
			}
		}
		System.out.println(isPal ? "Palindrome" : "Not Palindrome");

		System.out.println("15.");
		int[] evenOdd = {1, 2, 3, 4, 5, 6};
		System.out.print("Even: ");
		for (int i = 0; i < evenOdd.length; i++) {
			if (evenOdd[i] % 2 == 0) {
				System.out.print(evenOdd[i] + " ");
			}
		}
		System.out.print("\nOdd: ");
		for (int i = 0; i < evenOdd.length; i++) {
			if (evenOdd[i] % 2 != 0) {
				System.out.print(evenOdd[i] + " ");
			}
		}
	}
}
