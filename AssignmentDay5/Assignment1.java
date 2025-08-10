// Assignment 1: Student with Grade Validation & Configuration
package AssignmentDay5;

public class Assignment1 {
	public static void main(String[] args) {
		Student s = new Student("Hemant", 101, 105);
		s.displayDetails();
	}
}

class Student {
	private String name;
	private int rollNumber;
	private int marks;

	public Student(String name, int rollNumber, int marks) {
		this.name = name;
		this.rollNumber = rollNumber;
		if (marks >= 0 && marks <= 100) {
			this.marks = marks;
		} else {
			this.marks = 0;
		}
	}

	public String getName() { return name; }
	public int getRollNumber() { return rollNumber; }
	public int getMarks() { return marks; }

	public void displayDetails() {
		System.out.println("Name: " + name);
		System.out.println("Roll Number: " + rollNumber);
		System.out.println("Marks: " + marks);
	}
}