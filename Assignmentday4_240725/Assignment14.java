package Assignmentday4_240725;

/*5.Create: 

Interface Drawable with method draw() 

Abstract class Shape with abstract method area() 
Subclasses: Circle, Rectangle, and Triangle. 

Calculate area using appropriate formulas. 

Demonstrate how interface and abstract class work together. 

Shape */
interface Drawable {
    void draw();
}

abstract class Shape1 {
    abstract void area();
}

class Circle1 extends Shape1 implements Drawable {
    double r = 3;

    public void draw() {
        System.out.println("Drawing Circle");
    }

    void area() {
        System.out.println(3.14 * r * r);
    }
}

class Rectangle1 extends Shape1 implements Drawable {
    double l = 4, w = 5;

    public void draw() {
        System.out.println("Drawing Rectangle");
    }

    void area() {
        System.out.println(l * w);
    }
}

class Triangle extends Shape1 implements Drawable {
    double b = 6, h = 4;

    public void draw() {
        System.out.println("Drawing Triangle");
    }

    void area() {
        System.out.println(0.5 * b * h);
    }
}

public class Assignment14 {
    public static void main(String[] args) {
        Drawable d1 = new Circle1();
        d1.draw();
        ((Circle1)d1).area();

        Drawable d2 = new Rectangle1();
        d2.draw();
        ((Rectangle1)d2).area();

        Drawable d3 = new Triangle();
        d3.draw();
        ((Triangle)d3).area();
    }
}
