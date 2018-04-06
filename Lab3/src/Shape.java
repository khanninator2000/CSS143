import java.awt.*;

public class Shape {
    /**
     * Must be non-negative.
     */
    protected int x;
    protected int y;

    protected Color color;

    public Shape() {
        this(0, 0, Color.BLACK);
    }

    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Shape(Shape shape) {
        this(shape.x, shape.y, shape.color);
    }

    public void setX(int x) {
        if (x < 0) {
            return;
        }
        this.x = x;
    }

    public void setY(int y) {
        if (y < 0) {
            return;
        }
        this.y = y;
    }

    public double getArea() {
        return -1;
    }

    public void draw(Graphics g) {

    }

    @Override
    public String toString() {
        return "Shape (" + x + "," + y + ") and Color" + color.toString() + " and area " + getArea();
    }
}
