package Assignment;

public class SecondAssignment {
		// TODO Auto-generated method stub

	// 1. Create one employee class and in that class create instance variable, local variable and static variable.
	int empId;
	String empName;
	static String company = "Wipro";

	// 2. Addition of two numbers using variables
	public void addition() {
		int a = 15;
		int b = 25;
		int sum = a + b;
		System.out.println("Addition: " + sum);
	}

	// 3. Swap two numbers using third variable
	public void swap() {
		int x = 10;
		int y = 20;
		int temp = x;
		x = y;
		y = temp;
		System.out.println("After Swap: x = " + x + ", y = " + y);
	}

	// 4. Calculate area of rectangle
	public void areaOfRectangle() {
		int length = 8;
		int width = 5;
		int area = length * width;
		System.out.println("Area of Rectangle: " + area);
	}

	// 5. Calculate simple interest
	public void simpleInterest() {
		float principal = 5000;
		float rate = 7;
		float time = 2;
		float si = (principal * rate * time) / 100;
		System.out.println("Simple Interest: " + si);
	}

	// 6. Count number of vowels in a string(input=”Programming”, output=3 Vowels)
	public void countVowels() {
		String str = "Programming";
		str = str.toLowerCase();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				count++;
			}
		}
		System.out.println("Vowel Count: " + count);
	}

	// 7. Replace all Spaces with Hyphens
	public void replaceSpaces() {
		String str = "Java is fun to learn";
		String result = str.replace(" ", "-");
		System.out.println("After Replacement: " + result);
	}

	// 8. Check if a string is Palindrome
	public void checkPalindrome() {
		String str = "madam";
		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rev += str.charAt(i);
		}
		if (str.equals(rev)) {
			System.out.println(str + " is a Palindrome");
		} else {
			System.out.println(str + " is not a Palindrome");
		}
	}

	// 9. Count words in a Sentence
	public void countWords() {
		String sentence = "Java is powerful and versatile";
		String[] words = sentence.trim().split("\\s+");
		System.out.println("Word Count: " + words.length);
	}

	// 10. Check if String starts with “j” and ends with “a”
	public void startsAndEndsWith() {
		String word = "java";
		boolean condition = word.startsWith("j") && word.endsWith("a");
		System.out.println("Starts with 'j' and ends with 'a': " + condition);
	}

	// 11. Split a sentence into words
	public void splitSentence() {
		String sentence = "Learn Java Step by Step";
		String[] words = sentence.split(" ");
		for (String word : words) {
			System.out.println(word);
		}
	}

	// 12. Find the frequency of each character in a string
	public void charFrequency() {
		String str = "banana";
		int[] freq = new int[256];
		for (int i = 0; i < str.length(); i++) {
			freq[str.charAt(i)]++;
		}
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > 0) {
				System.out.println((char) i + ": " + freq[i]);
			}
		}
	}

	// 13. Remove all white Spaces from string
	public void removeWhiteSpaces() {
		String str = "  Java   is  Awesome  ";
		String noSpace = str.replaceAll("\\s", "");
		System.out.println("Without Spaces: " + noSpace);
	}

	// 14. Count digits, letters, spaces and Special characters
	public void countTypes() {
		String input = "Java 101! It's cool.";
		int digits = 0, letters = 0, spaces = 0, special = 0;

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (Character.isDigit(ch)) digits++;
			else if (Character.isLetter(ch)) letters++;
			else if (Character.isSpaceChar(ch)) spaces++;
			else special++;
		}

		System.out.println("Letters: " + letters);
		System.out.println("Digits: " + digits);
		System.out.println("Spaces: " + spaces);
		System.out.println("Special Characters: " + special);
	}

	// 15. Sort characters of a String Alphabetically
	public void sortCharacters() {
		String str = "dcba";
		char[] ch = str.toCharArray();
		java.util.Arrays.sort(ch);
		System.out.println("Sorted Characters: " + new String(ch));
	}

	public static void main(String[] args) {
		SecondAssignment obj = new SecondAssignment();

		System.out.println("1.");
		System.out.println("Instance Variable: empId = " + obj.empId + ", empName = " + obj.empName);
		System.out.println("Static Variable: company = " + company);
		System.out.println();

		System.out.println("2.");
		obj.addition();
		System.out.println();

		System.out.println("3.");
		obj.swap();
		System.out.println();

		System.out.println("4.");
		obj.areaOfRectangle();
		System.out.println();

		System.out.println("5.");
		obj.simpleInterest();
		System.out.println();

		System.out.println("6.");
		obj.countVowels();
		System.out.println();

		System.out.println("7.");
		obj.replaceSpaces();
		System.out.println();

		System.out.println("8.");
		obj.checkPalindrome();
		System.out.println();

		System.out.println("9.");
		obj.countWords();
		System.out.println();

		System.out.println("10.");
		obj.startsAndEndsWith();
		System.out.println();

		System.out.println("11.");
		obj.splitSentence();
		System.out.println();

		System.out.println("12.");
		obj.charFrequency();
		System.out.println();

		System.out.println("13.");
		obj.removeWhiteSpaces();
		System.out.println();

		System.out.println("14.");
		obj.countTypes();
		System.out.println();

		System.out.println("15.");
		obj.sortCharacters();
		System.out.println();

	}
}
