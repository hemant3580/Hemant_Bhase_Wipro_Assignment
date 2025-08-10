package Assignmentday4_240725;

/*Combined question 

Create an abstract class SmartDevice with methods like turnOn(), turnOff(), and performFunction(). 
Create child classes: 

SmartPhone: performs calling and browsing. 

SmartWatch: tracks fitness and time. 

SmartSpeaker: plays music and responds to voice commands. 

 

Write code to store all objects in an array and use polymorphism to invoke their performFunction(). */
abstract class SmartDevice {
    abstract void turnOn();
    abstract void turnOff();
    abstract void performFunction();
}

class SmartPhone extends SmartDevice {
    void turnOn() {
        System.out.println("Phone On");
    }

    void turnOff() {
        System.out.println("Phone Off");
    }

    void performFunction() {
        System.out.println("Calling and Browsing");
    }
}

class SmartWatch extends SmartDevice {
    void turnOn() {
        System.out.println("Watch On");
    }

    void turnOff() {
        System.out.println("Watch Off");
    }

    void performFunction() {
        System.out.println("Tracking Fitness and Time");
    }
}

class SmartSpeaker extends SmartDevice {
    void turnOn() {
        System.out.println("Speaker On");
    }

    void turnOff() {
        System.out.println("Speaker Off");
    }

    void performFunction() {
        System.out.println("Playing Music and Voice Commands");
    }
}

public class Assignment10 {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartPhone(),
            new SmartWatch(),
            new SmartSpeaker()
        };

        for (SmartDevice device : devices) {
            device.performFunction();
        }
    }
}
