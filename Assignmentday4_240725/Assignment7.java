package Assignmentday4_240725;

/*Create a base class Shape with a method area() that prints a message.                         Then create two subclasses                            Circleàoverride area() to calculator and print area of circle                                                  Rectangleà override area() to calculate and print area of a rectangle 
*/

class Shape {
    void area() {
        System.out.println("Calculating area...");
    }
}

class Circle extends Shape {
    double radius = 5;
    void area() {
        System.out.println(3.14 * radius * radius);
    }
}

class Rectangle extends Shape {
    double length = 4;
    double width = 6;
    void area() {
        System.out.println(length * width);
    }
}

public class Assignment7 {
    public static void main(String[] args) {
        Shape s1 = new Circle();
        s1.area();

        Shape s2 = new Rectangle();
        s2.area();
    }
}
