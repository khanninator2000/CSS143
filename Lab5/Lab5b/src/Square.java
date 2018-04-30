import java.awt.*;

public class Square extends Shape {
    int length;
    
    public Square() {
        super();
    }
    
    public Square(int x, int y, int length) {
        super(x, y);
        this.length = length;
        
    }
    
    public Square(int x, int y, Color color, int length) {
        super(x, y, color);
        this.length = length;
    }
    
    @Override
    public double getArea() {
        return length * length;
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(super.color);
        g.fillRect(x, y, length, length);
    }
}
