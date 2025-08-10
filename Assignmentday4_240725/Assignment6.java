package Assignmentday4_240725;
//Polymorphism: Create a class Calculator with the following

class Calculator {
    void add(int a, int b) {
        System.out.println(a + b);
    }

    void add(int a, int b, int c) {
        System.out.println(a + b + c);
    }

    void add(double a, double b) {
        System.out.println(a + b);
    }
}

public class Assignment6 {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.add(2, 3);
        c.add(1, 2, 3);
        c.add(2.5, 3.5);
    }
}
