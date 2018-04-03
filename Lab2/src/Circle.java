import java.awt.*;

public class Circle {
    private int x;
    private int y;
    private double radius;

    private String cout;

    private Color color;

    public Circle() {
        this(0, 0, 0);
    }

    public Circle(int x, int y) {
        this(x, y, 0);
    }

    public Circle(int x, int y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.cout = "O";
        this.color = Color.BLACK;
    }

    public void draw() {
        System.out.println(cout);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return cout;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Circle &&
                this.x == ((Circle)obj).x && this.y == ((Circle)obj).y &&
                this.radius == ((Square)obj).getArea();
    }
}
