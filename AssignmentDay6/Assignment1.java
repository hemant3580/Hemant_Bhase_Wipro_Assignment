package AssignmentDay6;

import java.util.*;
import java.io.*;

public class Assignment1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Type Casting: Implicit widening and explicit narrowing
		System.out.print("Enter an integer: ");
		int intVal = sc.nextInt();
		double doubleVal = intVal;
		System.out.println("Double value (widened): " + doubleVal);

		System.out.print("Enter a double: ");
		double inputDouble = sc.nextDouble();
		int castedInt = (int) inputDouble;
		short castedShort = (short) castedInt;
		System.out.println("Double to Int: " + castedInt);
		System.out.println("Int to Short (possible overflow): " + castedShort);

		// Convert int to String and back with error handling
		System.out.print("Enter an integer for conversion: ");
		String intString = String.valueOf(sc.nextInt());
		try {
			int parsedInt = Integer.parseInt(intString);
			System.out.println("Parsed back to int: " + parsedInt);
		} catch (NumberFormatException e) {
			System.out.println("Invalid integer string");
		}

		// Compound Assignment Behavior
		int x = 5;
		// x = x + 4.5; // compile error
		x += 4.5; // implicit narrowing to int
		System.out.println("Value of x after compound assignment: " + x);

		// Object Casting with Inheritance
		Dog d = new Dog();
		Animal a = d;
		a.makeSound();

		// Temperature Converter
		System.out.print("Enter Celsius temperature: ");
		double celsius = sc.nextDouble();
		double fahrenheit = celsius * 9 / 5 + 32;
		int truncatedF = (int) fahrenheit;
		System.out.println("Fahrenheit (double): " + fahrenheit);
		System.out.println("Fahrenheit (int): " + truncatedF);

		// Enum: Days of Week
		System.out.print("Enter a day: ");
		String dayInput = sc.next().toUpperCase();
		try {
			DaysOfWeek day = DaysOfWeek.valueOf(dayInput);
			System.out.println("Position: " + day.ordinal());
			switch (day) {
				case SATURDAY:
				case SUNDAY:
					System.out.println("It's a weekend");
					break;
				default:
					System.out.println("It's a weekday");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid day name");
		}

		// Enum: Compass Directions
		System.out.print("Enter direction (NORTH/SOUTH/EAST/WEST): ");
		String dirInput = sc.next().toUpperCase();
		try {
			Direction dir = Direction.valueOf(dirInput);
			switch (dir) {
				case NORTH:
					System.out.println("Move north");
					break;
				case SOUTH:
					System.out.println("Move south");
					break;
				case EAST:
					System.out.println("Move east");
					break;
				case WEST:
					System.out.println("Move west");
					break;
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid direction");
		}

		// Enum: Shape Area Calculator
		for (Shape s : Shape.values()) {
			switch (s) {
				case CIRCLE:
					System.out.println("Area of Circle: " + s.area(5));
					break;
				case SQUARE:
					System.out.println("Area of Square: " + s.area(4));
					break;
				case RECTANGLE:
					System.out.println("Area of Rectangle: " + s.area(4, 6));
					break;
				case TRIANGLE:
					System.out.println("Area of Triangle: " + s.area(4, 5));
					break;
			}
		}

		// Enum: Card Suit & Rank
		Deck deck = new Deck();
		deck.shuffle();
		deck.printDeck();

		// Enum: Priority Levels
		for (PriorityLevel p : PriorityLevel.values()) {
			System.out.println(p + " (Severity: " + p.severity + ") Urgent: " + p.isUrgent());
		}

		// Enum: Traffic Light
		TrafficLight light = TrafficLight.RED;
		for (int i = 0; i < 6; i++) {
			System.out.println("Light: " + light);
			light = (TrafficLight) light.next();
		}

		// Enum: Difficulty Levels & Game Setup
		Game g = new Game(Difficulty.MEDIUM);

		// Enum: Calculator Operation
		System.out.println("PLUS (switch): " + OperationSwitch.PLUS.eval(4, 5));
		System.out.println("MINUS (override): " + OperationOverride.MINUS.eval(10, 3));

		// Enum: Knowledge Level
		System.out.print("Enter score (0 to 10): ");
		int score = sc.nextInt();
		System.out.println("Knowledge Level: " + KnowledgeLevel.fromScore(score));

		// Exception Handling: Division & Array Access
		try {
			int res = 10 / 0;
		} catch (ArithmeticException e) {
			System.out.println("Division by zero is not allowed!");
		} finally {
			System.out.println("Operation completed.");
		}

		try {
			int[] arr = {1, 2, 3};
			System.out.println(arr[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid array index!");
		} finally {
			System.out.println("Operation completed.");
		}

		// Exception Handling: Custom Exception
		try {
			OddChecker.checkOdd(5);
		} catch (OddNumberException e) {
			System.out.println(e.getMessage());
		}

		// File Handling with Multiple Catches
		try {
			readFile("/HelloWorld/src/sample.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File not found: sample.txt");
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		} finally {
			System.out.println("Cleanup done.");
		}

		// Multi-Exception in One Try Block
		try {
			BufferedReader br = new BufferedReader(new FileReader("/HelloWorld/src/sample.txt"));
			String line = br.readLine();
			int num = Integer.parseInt(line);
			System.out.println(100 / num);
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Problem reading file");
		} catch (NumberFormatException e) {
			System.out.println("Invalid number format");
		} catch (ArithmeticException e) {
			System.out.println("Division by zero");
		} finally {
			System.out.println("Execution completed");
		}

		sc.close();
	}

	public static void readFile(String filename) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		System.out.println("First line: " + br.readLine());
		br.close();
	}
}

class Animal {
	void makeSound() {
		System.out.println("Animal sound");
	}
}

class Dog extends Animal {
	void makeSound() {
		System.out.println("Woof!");
	}

	void fetch() {
		System.out.println("Dog fetches ball");
	}
}

enum DaysOfWeek {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

enum Direction {
	NORTH, SOUTH, EAST, WEST;
}

enum Shape {
	CIRCLE {
		double area(double... params) {
			return Math.PI * params[0] * params[0];
		}
	},
	SQUARE {
		double area(double... params) {
			return params[0] * params[0];
		}
	},
	RECTANGLE {
		double area(double... params) {
			return params[0] * params[1];
		}
	},
	TRIANGLE {
		double area(double... params) {
			return 0.5 * params[0] * params[1];
		}
	};

	abstract double area(double... params);
}

enum Suit {
	CLUBS, DIAMONDS, HEARTS, SPADES
}

enum Rank {
	ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}

class Card {
	Suit suit;
	Rank rank;

	public Card(Suit s, Rank r) {
		this.suit = s;
		this.rank = r;
	}

	public String toString() {
		return rank + " of " + suit;
	}
}

class Deck {
	List<Card> cards = new ArrayList<>();

	public Deck() {
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				cards.add(new Card(s, r));
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public void printDeck() {
		for (Card c : cards) {
			System.out.println(c);
		}
	}
}

enum PriorityLevel {
	LOW(1), MEDIUM(3), HIGH(5), CRITICAL(10);

	int severity;

	PriorityLevel(int severity) {
		this.severity = severity;
	}

	boolean isUrgent() {
		return severity >= 5;
	}
}

interface State {
	State next();
}

enum TrafficLight implements State {
	RED {
		public State next() {
			return GREEN;
		}
	},
	GREEN {
		public State next() {
			return YELLOW;
		}
	},
	YELLOW {
		public State next() {
			return RED;
		}
	};
}

enum Difficulty {
	EASY, MEDIUM, HARD
}

class Game {
	Game(Difficulty diff) {
		switch (diff) {
			case EASY:
				System.out.println("Bullets: 3000");
				break;
			case MEDIUM:
				System.out.println("Bullets: 2000");
				break;
			case HARD:
				System.out.println("Bullets: 1000");
				break;
		}
	}
}

enum OperationSwitch {
	PLUS, MINUS, TIMES, DIVIDE;

	double eval(double a, double b) {
		switch (this) {
			case PLUS:
				return a + b;
			case MINUS:
				return a - b;
			case TIMES:
				return a * b;
			case DIVIDE:
				return b != 0 ? a / b : 0;
		}
		return 0;
	}
}

enum OperationOverride {
	PLUS {
		double eval(double a, double b) {
			return a + b;
		}
	},
	MINUS {
		double eval(double a, double b) {
			return a - b;
		}
	},
	TIMES {
		double eval(double a, double b) {
			return a * b;
		}
	},
	DIVIDE {
		double eval(double a, double b) {
			return b != 0 ? a / b : 0;
		}
	};

	abstract double eval(double a, double b);
}

enum KnowledgeLevel {
	BEGINNER, ADVANCED, PROFESSIONAL, MASTER;

	static KnowledgeLevel fromScore(int score) {
		if (score <= 3)
			return BEGINNER;
		else if (score <= 6)
			return ADVANCED;
		else if (score <= 9)
			return PROFESSIONAL;
		else
			return MASTER;
	}
}

class OddNumberException extends Exception {
	public OddNumberException(String msg) {
		super(msg);
	}
}

class OddChecker {
	public static void checkOdd(int n) throws OddNumberException {
		if (n % 2 != 0)
			throw new OddNumberException("Odd number: " + n);
	}
}
