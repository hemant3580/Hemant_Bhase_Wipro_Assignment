package Assignmentday4_240725;
//Create Hierarchical inheritance after 12th
class After_12Th {
    void show() {
        System.out.println("Options after 12th");
    }
}

class Engineering extends After_12Th {
    void showEngineering() {
        System.out.println("Engineering Options");
    }
}

class Medical extends After_12Th {
    void showMedical() {
        System.out.println("Medical Options");
    }
}

class Other_courses extends After_12Th {
    void showOtherCourses() {
        System.out.println("Other Courses Options");
    }
}

class IT extends Engineering {
    void showIT() {
        System.out.println("IT Branch");
    }
}

class Mechanical extends Engineering {
    void showMechanical() {
        System.out.println("Mechanical Branch");
    }
}

class CS extends Engineering {
    void showCS() {
        System.out.println("CS Branch");
    }
}

class MBBS extends Medical {
    void showMBBS() {
        System.out.println("MBBS Course");
    }
}

class BDS extends Medical {
    void showBDS() {
        System.out.println("BDS Course");
    }
}

class BBA extends Other_courses {
    void showBBA() {
        System.out.println("BBA Course");
    }
}

class BCA extends Other_courses {
    void showBCA() {
        System.out.println("BCA Course");
    }
}

public class Assignment4 {
    public static void main(String[] args) {
        IT it = new IT();
        it.show();
        it.showEngineering();
        it.showIT();

        MBBS mbbs = new MBBS();
        mbbs.show();
        mbbs.showMedical();
        mbbs.showMBBS();

        BCA bca = new BCA();
        bca.show();
        bca.showOtherCourses();
        bca.showBCA();
    }
}
