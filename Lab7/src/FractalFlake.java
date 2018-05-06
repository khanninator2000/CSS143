import java.awt.*;

public class FractalFlake extends Shape {
    private final int limit = 90;
    private final int branches = 6;
    
    private int size;
    
    public FractalFlake(int size) {
        super();
        this.size = size;
    }
    
    public FractalFlake(int x, int y, int size) {
        super(x, y);
        this.size = size;
    }
    
    public FractalFlake(int x, int y, Color color, int size) {
        super(x, y, color);
        this.size = size;
    }
    
    @Override
    public double getArea() {
        return 0;
    }
    
    @Override
    public void draw(Graphics g) {
        draw((Graphics2D)g, getX(), getY(), limit);
    }
    
    private void draw(Graphics2D g, int x, int y, final int limit) {
        if(limit>= 3) {
            for(int i = 0; i < branches; i++) {
                int x2 = x + (int) (size * Math.cos( (2 * Math.PI/ branches) * i ));
                int y2 = y - (int) (size * Math.sin( (2 * Math.PI/ branches) * i ));
                g.drawLine(x, y, x2, y2);//do a branch
                draw(g, x2, y2, limit/3);
            }
        }
    }
}
