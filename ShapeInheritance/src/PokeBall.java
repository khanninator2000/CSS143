import java.awt.*;

public class PokeBall extends Shape {
    private int size;
    
    public PokeBall(int x, int y, int size) {
        super(x, y);
        this.size = size;
    }
    
    @Override
    public void draw(Graphics g) {
        int x = getX(), y = getY();
        int bar_height = size/15;
        int button_radius = size/5;
        
        g.setColor(Color.BLACK);
        g.drawOval(x, y, size, size); //Outline
        
        g.setColor(Color.RED);
        g.fillArc(x, y, size, size, 0, 180); //Top half
    
        g.setColor(Color.WHITE);
        g.fillArc(x, y, size, size, 180, 180); //Bottom half
    
        g.setColor(Color.BLACK);
        g.fillRoundRect(x, y+size/2 - bar_height/2, size, bar_height, 0, bar_height/8); //Bar in the middle
        g.fillOval(x+size/2 - button_radius/2, y+size/2 - button_radius/2, button_radius, button_radius);
        
        g.setColor(Color.WHITE);
        g.fillOval(x+size/2 - button_radius/4, y+size/2 - button_radius/4, button_radius/2, button_radius/2);
    }
}
