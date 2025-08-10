package Assignmentday4_240725;
// Create Hospital super class and access this class inside the patient child class and access properties from Hospital class.
class Hospital1 {
    String city;

    Hospital1(String city) {
        this.city = city;
    }

    void displayCity() {
        System.out.println("Hospital is in " + city);
    }
}

class Patient1 extends Hospital1 {
    String patientName;

    Patient1(String city, String patientName) {
        super(city);
        this.patientName = patientName;
    }

    void showPatient() {
        System.out.println("Patient Name: " + patientName);
        displayCity();
    }
}

public class Assignment3 {
    public static void main(String[] args) {
        Patient1 p = new Patient1("Pune", "Rahul");
        p.showPatient();
    }
}
