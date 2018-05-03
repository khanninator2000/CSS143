import java.awt.*;

import static java.lang.Math.PI;

public class Cylinder extends Shape {
    private double radius, height;
    
    public Cylinder(int x, int y) {
        super(x, y);
    }
    
    public Cylinder(int x, int y, double radius, double height, Color color) {
        super(x, y, color);
        this.radius = radius;
        this.height = height;
    }
    
    @Override
    public double getArea() {
        return 2 * PI * radius * height + 2 * PI * radius * radius;
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(super.color);
        
//        g.drawRoundRect(getX(), getY(), radius*2, height, radius*2, height/10);
//        g.drawArc(getX(), getY(), radius*2, height/10, 0, -180);
//        g.drawArc(getX(), getY()+height-height/10, radius*2, height/10, 0, 180);
        
        g.drawOval(getX(), getY(), (int)radius*2, (int)height/10);
        g.drawLine(getX(), getY()+(int)height/20, getX(), getY()+(int)height);
        g.drawLine(getX()+(int)radius*2, getY()+(int)height/20, getX()+(int)radius*2, getY()+(int)height);
        g.drawOval(getX(), getY()+(int)height - (int)height/20, (int)radius*2, (int)height/10);
    }
}
