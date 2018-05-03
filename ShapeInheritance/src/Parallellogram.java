import java.awt.*;

public class Parallellogram extends Shape {
    public int width, height;
    
    public Parallellogram(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }
    
    public Parallellogram(int x, int y, Color color) {
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
        
        g.fillPolygon(x_p, y_p, 4);
    }
}
