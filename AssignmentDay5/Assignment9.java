package AssignmentDay5;

interface BaseVehicle {
    void start();
}

interface AdvancedVehicle extends BaseVehicle {
    void stop();
    boolean refuel(int amount);
}

class Car1 implements AdvancedVehicle {
    int fuel;

    Car1(int fuel) {
        this.fuel = fuel;
    }

    public void start() {
        if (fuel > 0) {
            System.out.println("Car started");
        } else {
            System.out.println("No fuel to start");
        }
    }

    public void stop() {
        System.out.println("Car stopped");
    }

    public boolean refuel(int amount) {
        fuel += amount;
        return true;
    }
}

public class Assignment9 {
    public static void main(String[] args) {
        AdvancedVehicle av = new Car1(0);
        av.start();
        av.refuel(10);
        av.start();
        av.stop();

        BaseVehicle bv = new Car1(5);
        bv.start();
    }
}
