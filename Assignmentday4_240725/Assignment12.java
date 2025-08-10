package Assignmentday4_240725;

/*3 

Create a base class Vehicle with method start(). 
Derive Car, Bike, and Truck from it and override the start() method. 

Create a static method that accepts Vehicle type and calls start(). 

Pass different vehicle objects to test polymorphism. 

Shape */
class Vehicle2 {
    void start() {
        System.out.println("Vehicle Starting");
    }
}

class Car extends Vehicle2{
    void start() {
        System.out.println("Car Starting");
    }
}

class Bike2 extends Vehicle2 {
    void start() {
        System.out.println("Bike Starting");
    }
}

class Truck extends Vehicle2 {
    void start() {
        System.out.println("Truck Starting");
    }
}

public class Assignment12 {
    static void testStart(Vehicle2 v) {
        v.start();
    }

    public static void main(String[] args) {
        testStart(new Car());
        testStart(new Bike2());
        testStart(new Truck());
    }
}
