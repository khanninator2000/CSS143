import java.awt.*;

public class Circle extends Shape {
    private double radius;

    public Circle(int x, int y, double radius) {
        this(x, y, radius, new Color(new java.util.Random().nextInt(0xFF_FF_FF)));
    }

    public Circle(int x, int y, double radius, Color color) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * (radius * radius);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawOval(x, y, (int)radius, (int)radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
