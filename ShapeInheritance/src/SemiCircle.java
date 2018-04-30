import java.awt.*;

import static java.lang.Math.*;

/**
 * Subclass to store data for a semicircle (ex. half a circle).
 */
public class SemiCircle extends Shape {
    /**
     * Distance between the origin and any point in the arc.
     */
    private double radius;
    
    /**
     * The start angle of the arc.
     */
    private double start_angle;
    
    /**
     *
     * @param x x_coordinate of the top left corner of the semicircle.
     * @param y y_coordinate of the top left corner of the semicircle.
     * @param radius The radius of the semicircle
     * @param start_angle The angle the arc starts on, in degrees.
     */
    public SemiCircle(int x, int y, double radius, double start_angle) {
        super(x, y, new Color((int)(random() * 0xFFFFFF)));
        this.radius = radius;
        this.start_angle = start_angle;
    }
    
    /**
     * Gets the area of the semicircle.
     * The area is calculated by A = PI * radius * radius / 2
     *
     * @return The area of the semicircle as a double.
     */
    @Override
    public double getArea() {
        return PI * radius * radius / 2;
    }
    
    /**
     * Draws the semicircle
     *
     * @param g Graphics context
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillArc(getX(), getY(),
                 (int)radius, (int)radius,
                 (int)start_angle, (int)(start_angle + 180.));
    }
    
    public double get_radius() {
        return radius;
    }
    
    public void set_radius(double radius) {
        this.radius = radius;
    }
    
    public double get_start_angle() {
        return start_angle;
    }
    
    public void set_start_angle(double start_angle) {
        this.start_angle = start_angle;
    }
}
