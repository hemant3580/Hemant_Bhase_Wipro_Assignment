package Assignmentday4_240725;
//multilevel inheritance for vehicle
class Vehicle {
    void showVehicle() {
        System.out.println("This is a Vehicle");
    }
}

class Four_wheeler extends Vehicle {
    void showFourWheeler() {
        System.out.println("This is a Four Wheeler");
    }
}

class Petrol_Four_Wheeler extends Four_wheeler {
    void showPetrolFourWheeler() {
        System.out.println("This is a Petrol Four Wheeler");
    }
}

class FiveSeater_Petrol_Four_Wheeler extends Petrol_Four_Wheeler {
    void showFiveSeater() {
        System.out.println("This is a Five Seater Petrol Four Wheeler");
    }
}

class Baleno_FiveSeater_Petrol_Four_Wheeler extends FiveSeater_Petrol_Four_Wheeler {
    void showBaleno() {
        System.out.println("This is a Baleno Car");
    }
}

public class Assignment1 {
    public static void main(String[] args) {
        Baleno_FiveSeater_Petrol_Four_Wheeler car = new Baleno_FiveSeater_Petrol_Four_Wheeler();
        car.showVehicle();
        car.showFourWheeler();
        car.showPetrolFourWheeler();
        car.showFiveSeater();
        car.showBaleno();
    }
}
