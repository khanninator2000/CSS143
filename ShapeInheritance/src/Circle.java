import java.awt.*;

public class Circle extends Shape {
    private double radius;

    public Circle(int x, int y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);

        g.setColor(super.color);

        g.drawOval(getX(), getY(), (int)radius, (int)radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
