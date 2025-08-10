package AssignmentDay5;

interface Movable {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}

class MovablePoint implements Movable {
    int x, y, xSpeed, ySpeed;

    MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void moveUp() {
        y += ySpeed;
    }

    public void moveDown() {
        y -= ySpeed;
    }

    public void moveLeft() {
        x -= xSpeed;
    }

    public void moveRight() {
        x += xSpeed;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

class MovableCircle implements Movable {
    int radius;
    MovablePoint center;

    MovableCircle(int radius, MovablePoint center) {
        this.radius = radius;
        this.center = center;
    }

    public void moveUp() {
        center.moveUp();
    }

    public void moveDown() {
        center.moveDown();
    }

    public void moveLeft() {
        center.moveLeft();
    }

    public void moveRight() {
        center.moveRight();
    }

    public String toString() {
        return "Center: " + center + ", Radius: " + radius;
    }
}

class MovableRectangle implements Movable {
    MovablePoint topLeft;
    MovablePoint bottomRight;

    MovableRectangle(MovablePoint topLeft, MovablePoint bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public void moveUp() {
        topLeft.moveUp();
        bottomRight.moveUp();
    }

    public void moveDown() {
        topLeft.moveDown();
        bottomRight.moveDown();
    }

    public void moveLeft() {
        topLeft.moveLeft();
        bottomRight.moveLeft();
    }

    public void moveRight() {
        topLeft.moveRight();
        bottomRight.moveRight();
    }

    public String toString() {
        return "TopLeft: " + topLeft + ", BottomRight: " + bottomRight;
    }
}

public class Assignment7 {
    public static void main(String[] args) {
        MovablePoint p = new MovablePoint(0, 0, 2, 3);
        MovableCircle c = new MovableCircle(5, new MovablePoint(1, 1, 2, 2));
        MovableRectangle r = new MovableRectangle(new MovablePoint(0, 5, 1, 1), new MovablePoint(5, 0, 1, 1));

        p.moveUp();
        c.moveRight();
        r.moveDown();

        System.out.println("Point: " + p);
        System.out.println("Circle: " + c);
        System.out.println("Rectangle: " + r);
    }
}
