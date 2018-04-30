import java.awt.*;

/* Class Shape
 *
 * By Rob Nash
 * 
 * This is the superclass in a hierarchy of shapes that you have to construct
 */

//the superclass in our inheritance hierarchy
//all "common" features, functions and data should go here
//for example, all shapes in Java2D have a x,y that declares their position
//and many of the shapes exposed have a width and a height (but not all, so we didn't put width and height here)
//note that this class is mostly empty, as there is no algorithm generic enough to guess an arbitrary shape's area (future subclasses must override getArea() to provide something reasonable)
//also, the draw method is empty too, as we don't know what shape to draw here! (again, our subclasses will need to replace this method with one that actually draws things)
public abstract class Shape {
	protected int x;
	protected int y;
	protected Color color;

    public Shape() {
        this(0, 0, new Color(new java.util.Random().nextInt(0xFF_FF_FF)));
    }

    public Shape(int x, int y) {
        this(x, y, new Color(new java.util.Random().nextInt(0xFF_FF_FF)));
    }

    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public abstract double getArea();
	
	public abstract void draw(Graphics g);

    public final int getX() {
	    return x;
	}

    public final int getY() {
	    return y;
	}
}