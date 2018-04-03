import java.awt.*;

/**
 * Write a description of class Shape here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shape {
    int x;

    private Point point;
    private Dimension dimension;
    private Color color;

    /**
     * Constructor for objects of class Shape
     */
    public Shape() {
        // initialise instance variables
        x = 0;

        point = new Point(0, 0);
        dimension = new Dimension(10, 10);
        color = Color.YELLOW;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)  {
        // put your code here
        return x + y;
    }
}
