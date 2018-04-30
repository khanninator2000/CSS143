import java.awt.*;

public class ExtrudedRectangle extends Shape {
    int width;
    int height;
    
    public ExtrudedRectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public ExtrudedRectangle(int x, int y, int width, int height) {
        super(x, y, new Color(new java.util.Random().nextInt(0xFFFFFF)));
        this.width = width;
        this.height = height;
    }
    
    public ExtrudedRectangle(int x, int y, Color color, int width, int height) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double getArea() {
        return width * height;
    }
    
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.fill3DRect(x, y, width, height, true);
    }
}
