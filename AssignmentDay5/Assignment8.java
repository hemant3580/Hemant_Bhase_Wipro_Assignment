package AssignmentDay5;

interface Printer {
    void print(String document);
}

class LaserPrinter implements Printer {
    public void print(String document) {
        System.out.println("LaserPrinter: " + document);
    }
}

class InkjetPrinter implements Printer {
    public void print(String document) {
        System.out.println("InkjetPrinter: " + document);
    }
}

public class Assignment8 {
    public static void main(String[] args) {
        Printer p;

        p = new LaserPrinter();
        p.print("Laser printing document...");

        p = new InkjetPrinter();
        p.print("Inkjet printing document...");
    }
}
