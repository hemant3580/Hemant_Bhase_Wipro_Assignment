package Assignmentday4_240725;
//Demonstrate the use of the super keyword 
class Hospital {
    String name = "XYZ Hospital";

    void hospitalInfo() {
        System.out.println("Welcome to " + name);
    }
}

class Patient extends Hospital {
    void patientDetails() {
        System.out.println("Patient registered at " + super.name);
        super.hospitalInfo();
    }
}

public class Assignment2 {
    public static void main(String[] args) {
        Patient p = new Patient();
        p.patientDetails();
    }
}
