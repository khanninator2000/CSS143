import java.awt.*;

/**
 * Subclass to contain a square
 */
public class Square extends Shape {
    /**
     * Side length of the square
     */
    private double length;
    
    /**
     * Constructor for a Square
     *
     * @param x x-coordinate for the top left corner
     * @param y y-coordinate for the top left corner
     * @param length side length of the square
     * @param color rgb color for the square
     */
    public Square(int x, int y, double length, int color) {
        super(x, y, new Color(color));
        this.length = length;
    }
    
    /**
     * Calculates the area of the square from the given length.
     *
     * @return The area of the square
     */
    @Override
    public double getArea() {
        return length * length;
    }
    
    /**
     * Draws the square.
     *
     * @param g Graphics context
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(super.color);
        g.fillRect(getX(), getY(), (int)length, (int)length);
    }
    
    public double get_length() {
        return length;
    }
    
    public void set_length(double length) {
        this.length = length;
    }
}
