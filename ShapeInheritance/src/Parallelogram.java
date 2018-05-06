import java.awt.*;

public class Parallelogram extends Shape {
    public int width, height;
    
    public Parallelogram(int x, int y, int width, int height, int color) {
        super(x, y, new Color(color));
        this.width = width;
        this.height = height;
    }
    
    public Parallelogram(int x, int y, Color color) {
        super(x, y, color);
    }
    
    @Override
    public double getArea() {
        return width * height;
    }
    
    @Override
    public void draw(Graphics g) {
        int x = super.getX();
        int y = super.getY();
        int[] x_p = {x, x+width/2, x + width + width/2, x + width};
        int[] y_p = {y + height, y, y, y+height};
        g.setColor(color);
        g.fillPolygon(x_p, y_p, 4);
    }
}
