import java.awt.*;

import static java.lang.Math.PI;

public strictfp class Circle extends Shape {
    /**
     * Distance from the center to any edge.
     */
    private double radius;

    public Circle(int x, int y, double radius) {
        super(x, y);
        this.radius = radius;
    }
    
    /**
     * Returns a double with the area of the circle with this radius.
     * The area is calculated by A = π*r*r.
     *
     * @return The area of this circle as a double.
     */
    @Override
    public double getArea() {
        return PI * radius * radius;
    }
    
    /**
     * Draws a circle with origin at (x+radius/2, y+radius/2).
     *
     * @param g Graphics context
     */
    @Override
    public void draw(Graphics g) {
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
