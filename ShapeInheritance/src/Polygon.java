import java.awt.*;

import static java.lang.StrictMath.PI;
import static java.lang.StrictMath.sin;
import static java.lang.StrictMath.cos;
import static java.util.stream.IntStream.range;

/**
 * Subclass to draw and get the area of a regular polygon.
 */
public strictfp class Polygon extends Shape {
    /**
     * Distance from the center of the polygon to any vertex.
     */
    private double radius;
    
    /**
     * Number of sides of the polygon.
     */
    private int num_sides;
    
    /**
     * Constructor to initialize the polygon.
     *
     * @param x x-coordinate of the polygon's origin.
     * @param y y-coordinate of the polygon's origin.
     * @param radius Distance from the origin to any vertex.
     * @param color_rgb Color of the polygon, represented as an integer.
     * @param num_sides Number of edges this polygon has.
     */
    public Polygon(int x, int y, double radius, int color_rgb, int num_sides) {
        super(x, y, new Color(color_rgb));
        this.radius = radius;
        this.num_sides = num_sides;
    }
    
    /**
     * Returns the area of this polygon.
     * Because the polygon is a regular polygon, the area is:
     * A = 1/2 * perimeter * apothem
     *
     * @return The area of the polygon given as a double.
     */
    @Override
    public double getArea() {
        double angle = PI/num_sides;
        double perimeter = num_sides * 2 * radius * sin(angle);
        double apothem = radius * cos(angle);
        return 0.5 * perimeter * apothem;
    }
    
    /**
     * Draws the polygon, centered at (x, y).
     *
     * @param g Graphics context
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(super.color);
        g.fillPolygon(range(0, num_sides).map(t->(int)(radius * sin(t*2*PI/num_sides) + getX())).toArray(),
                      range(0, num_sides).map(t->(int)(radius * cos(t*2*PI/num_sides) + getY())).toArray(),
                      num_sides);
    }
    
    public double get_radius() {
        return radius;
    }
    
    public void set_radius(double radius) {
        this.radius = radius;
    }
    
    public int get_num_sides() {
        return num_sides;
    }
    
    public void set_num_sides(int num_sides) {
        this.num_sides = num_sides;
    }
}
