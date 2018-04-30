import java.awt.*;

/**
 * Generic Shape class. Methods of this class is to be overridden.
 * Draw() is abstract because all Shapes need to be drawn on a graphics context.
 */
public abstract class Shape {
    /**
     * The x-coordinate of the shape. Whether it is the corner or the center coordinate is
     * up to the subclass implementation.
     */
	private int x;
    
    /**
     * The x-coordinate of the shape. Whether it is the corner or the center coordinate is
     * up to the subclass implementation.
     */
	private int y;
    
    /**
     * The color the Shape.
     */
	protected Color color;
    
    /**
     * Constructor with x and y coordinates.
     * Color is initialized to black.
     *
     * @param x The x coordinate as an int.
     * @param y The y coordinate as an int
     */
	public Shape(int x, int y) {
		this(x, y, new Color(0));
	}
    
    /**
     * Constructor with x and y coordinates and color.
     *
     * @param x The x coordinate, as an int.
     * @param y The y coordinate, as an int.
     * @param color The color of the Shape
     */
    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    /**
     * Method for subclasses to optionally override.
     * This method returns -1 because getting a
     * deterministic area is impossible.
     *
     * @return -1 as a double.
     */
    public double getArea() {
		return -1.;
	}
    
    /**
     * Method for subclasses to override.
     *
     * @param g Graphics context
     */
	public abstract void draw(Graphics g);
	
	public final int getX() {
	    return x;
	}

	public final int getY() {
	    return y;
	}
}