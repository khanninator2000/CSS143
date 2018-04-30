import java.awt.*;
import java.awt.geom.*;

/**
 * Area-less series of circles drawn with a gradient paint.
 */
class Spray extends Shape {
	private final int RADIUS = 20;
	private final int DENSITY = 10;
	
	public Spray(int a, int b) {
		super(a, b); 	//we explicitly call a superclass constructor that takes 2 ints
	}
    
    /**
     * Draws the Spray
     *
     * @param g Graphics context
     */
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.GREEN);
		g2d.setPaint(new GradientPaint(getX(), getY(), Color.GREEN,
                                       getX() + RADIUS/4, getY() + RADIUS/4, Color.BLACK,
                                       true));
		
		for(int i = 0; i < DENSITY; i++) {
			int xOffset = (int)(Math.random()*RADIUS);
			int yOffset = (int)(Math.random()*RADIUS);
			g2d.draw(new Ellipse2D.Double(getX() + xOffset, getY() + yOffset,
                                          getX() + xOffset+3, getY() + yOffset+3));
		}
	}
}