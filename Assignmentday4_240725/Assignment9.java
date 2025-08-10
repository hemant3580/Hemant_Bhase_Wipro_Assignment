package Assignmentday4_240725;

/*Runtime Polymorphism with constructor Chaining                                                             create a class vehicle with a constructor that prints “Vehicle Created” 

Create a subclass Bike that override a method and uses super() in constructor 

 */
class Vehicle1 {
    Vehicle1() {
        System.out.println("Vehicle Created");
    }

    void run() {
        System.out.println("Vehicle running");
    }
}

class Bike extends Vehicle1 {
    Bike() {
        super();
        System.out.println("Bike Created");
    }

    void run() {
        System.out.println("Bike running");
    }
}

public class Assignment9 {
    public static void main(String[] args) {
        Vehicle1 v = new Bike();
        v.run();
    }
}
