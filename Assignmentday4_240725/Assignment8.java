package Assignmentday4_240725;

/*Create a Bank class with a method getInterestRate()                                               create subclasses:                                           SBIàreturn 6.7%                                            ICICIàreturn 7.0%                                             HDFCàreturn 7.5% 
*/

class Bank {
    double getInterestRate() {
        return 0;
    }
}

class SBI extends Bank {
    double getInterestRate() {
        return 6.7;
    }
}

class ICICI extends Bank {
    double getInterestRate() {
        return 7.0;
    }
}

class HDFC extends Bank {
    double getInterestRate() {
        return 7.5;
    }
}

public class Assignment8 {
    public static void main(String[] args) {
        Bank b1 = new SBI();
        System.out.println(b1.getInterestRate());

        Bank b2 = new ICICI();
        System.out.println(b2.getInterestRate());

        Bank b3 = new HDFC();
        System.out.println(b3.getInterestRate());
    }
}
