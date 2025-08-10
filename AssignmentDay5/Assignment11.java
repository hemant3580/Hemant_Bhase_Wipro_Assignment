package AssignmentDay5;

interface Polygon {
    double getArea();

    default double getPerimeter(int... sides) {
        int sum = 0;
        for (int side : sides) {
            sum += side;
        }
        return sum;
    }

    static String shapeInfo() {
        return "Polygon is a closed shape with straight sides";
    }
}

class Rectangle2 implements Polygon {
    int length, breadth;

    Rectangle2(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double getArea() {
        return length * breadth;
    }
}


class Triangle1 implements Polygon {
    int base, height;

    Triangle1(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public double getArea() {
        return 0.5 * base * height;
    }
}

public class Assignment11 {
    public static void main(String[] args) {
        Rectangle2 r = new Rectangle2(4, 5);
        Triangle1 t = new Triangle1(6, 3);

        System.out.println("Rectangle Area: " + r.getArea());
        System.out.println("Rectangle Perimeter: " + r.getPerimeter(4, 5, 4, 5));

        System.out.println("Triangle Area: " + t.getArea());
        System.out.println("Triangle Perimeter: " + t.getPerimeter(3, 4, 5));

        System.out.println(Polygon.shapeInfo());
    }
}
