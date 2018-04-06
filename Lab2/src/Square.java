import java.awt.*;

public class Square {
    private int x;
    private int y;
    private double length;

    private String output_string;

    private Color color;

    public Square() {
        this(0, 0, 0);
    }

    public Square(int x, int y) {
        this(x, y, 0);
    }

    public Square(int x, int y, double length) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.output_string = "[]";
        this.color = Color.BLACK;
    }

    public void draw() {
        System.out.println(output_string);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getLength() {
        return length;
    }

    public double getArea() {
        return length * length;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return output_string;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Square &&
                this.x == ((Square)obj).x && this.y == ((Square)obj).y &&
                this.length == ((Square)obj).length;
    }
}
