// Assignment 2: Rectangle Enforced Positive Dimensions
package AssignmentDay5;

public class Assignment2 {
	public static void main(String[] args) {
		Rectangle r = new Rectangle(10, -5);
		r.displayDetails();
	}
}

class Rectangle {
	private int width;
	private int height;

	public Rectangle(int width, int height) {
		this.width = width > 0 ? width : 1;
		this.height = height > 0 ? height : 1;
	}

	public void setWidth(int width) {
		if (width > 0) this.width = width;
	}

	public void setHeight(int height) {
		if (height > 0) this.height = height;
	}

	public int getArea() {
		return width * height;
	}

	public int getPerimeter() {
		return 2 * (width + height);
	}

	public void displayDetails() {
		System.out.println("Width: " + width);
		System.out.println("Height: " + height);
		System.out.println("Area: " + getArea());
		System.out.println("Perimeter: " + getPerimeter());
	}
}